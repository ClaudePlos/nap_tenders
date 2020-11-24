package pl.kskowronski.data.service.inap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import pl.kskowronski.data.MapperDate;
import pl.kskowronski.data.entity.egeria.ckk.Address;
import pl.kskowronski.data.entity.egeria.ckk.Client;
import pl.kskowronski.data.entity.inap.Tender;
import pl.kskowronski.data.entity.inap.TenderDTO;
import pl.kskowronski.data.entity.inap.TenderDate;
import pl.kskowronski.data.service.egeria.ckk.AddressRepo;
import pl.kskowronski.data.service.egeria.ckk.ClientRepo;

import java.math.BigDecimal;
import java.util.*;

@Service
public class TenderService extends CrudService<Tender, BigDecimal> {

    private TenderRepo repo;

    public TenderService(@Autowired TenderRepo repo) {
        this.repo = repo;
    }

    @Override
    protected TenderRepo getRepository() {
        return repo;
    }

    @Autowired
    ClientRepo clientRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    TenderDateRepo tenderDateRepo;

    private MapperDate mapperDate = new MapperDate();

    public Optional<List<TenderDTO>> getAllTendersBeforePlacing(String numberOfDays){
        Optional<List<TenderDTO>> tendersDTO = Optional.of(new ArrayList<>());
        Optional<List<Tender>> tenders = repo.getAllTendersBeforePlacing(numberOfDays);
        if (tenders.isPresent()){
            tenders.get().stream().forEach( item -> tendersDTO.get().add( mapperTender(item)));
        }
        return tendersDTO;
    }


    private TenderDTO mapperTender( Tender t){
        TenderDTO tDTO = new TenderDTO();
        tDTO.setId(t.getId());
        tDTO.setAktywnosc(t.getAktywnosc());
        tDTO.setDataOgloszenia(t.getDataOgloszenia());
        tDTO.setDlugoscUmowy(t.getDlugoscUmowy());
        tDTO.setFormaPostepowania(t.getFormaPostepowania());
        tDTO.setResponsiblePersonFormal(t.getResponsiblePersonFormal());
        tDTO.setPackageNumber(t.getNumerPakietu());
        tDTO.setPriority(t.getPriorytet());
        tDTO.setParticipate(t.getParticipate());
        tDTO.setTenderType(t.getTypPrzetargu());

        Optional<Client> client = clientRepo.getClientByKlKod(t.getZamawiajacyId());
        Optional<Address> address = addressRepo.getMainAddressForClient(t.getZamawiajacyId());
        Optional<TenderDate> tenderDeadline = tenderDateRepo.getTenderDeadline(t.getId());

        if (client.isPresent()){
            tDTO.setPurchaser( client.get().getKldNazwa());
        }

        if (address.isPresent()){
            tDTO.setCity(address.get().getMiejscowosc());
        }

        if (tenderDeadline.isPresent()){
            tDTO.setDeadlineApplication(mapperDate.dtYYYYMMDDHHMM.format(tenderDeadline.get().getData()));
        }

        return tDTO;
    }

}

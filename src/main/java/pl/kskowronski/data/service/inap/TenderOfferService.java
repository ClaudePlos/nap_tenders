package pl.kskowronski.data.service.inap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import pl.kskowronski.data.entity.egeria.ckk.Client;
import pl.kskowronski.data.entity.inap.Tender;
import pl.kskowronski.data.entity.inap.TenderOffer;
import pl.kskowronski.data.entity.inap.TenderOfferDTO;
import pl.kskowronski.data.service.egeria.ckk.ClientRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TenderOfferService extends CrudService<TenderOffer, BigDecimal> {

    private TenderOfferRepo repo;

    public TenderOfferService(@Autowired TenderOfferRepo repo) {
        this.repo = repo;
    }

    @Override
    protected TenderOfferRepo getRepository() {
        return repo;
    }

    @Autowired
    private ClientRepo clientRepo;


    public Optional<List<TenderOfferDTO>> getTendersOffersForTender(BigDecimal przId){
        Optional<List<TenderOfferDTO>> offersDTO = Optional.of(new ArrayList<>());
        Optional<List<TenderOffer>> offers = repo.getTendersOffersForTender(przId);
        if (offers.isPresent()){
            offers.get().stream().forEach( item -> offersDTO.get().add(mapperTenderOffer(item)));
        }
        return offersDTO;
    };

    private TenderOfferDTO mapperTenderOffer( TenderOffer offer){
        TenderOfferDTO offerDTO = new TenderOfferDTO();
        offerDTO.setId(offer.getId());
        offerDTO.setPrzId(offer.getPrzId());
        offerDTO.setDesc(offer.getOpis());
        offerDTO.setGross(offer.getWartoscBrutto());
        offerDTO.setNet(offer.getWartoscNetto());
        offerDTO.setResult(offer.getStatusWyniku());
        Optional<Client> client = clientRepo.getClientByKlKod(offer.getKlKod());
        if (client.isPresent()) {
            offerDTO.setClient(client.get().getKldNazwa());
        }
        return offerDTO;
    }

}

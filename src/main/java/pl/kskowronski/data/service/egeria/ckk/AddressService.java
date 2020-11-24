package pl.kskowronski.data.service.egeria.ckk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import pl.kskowronski.data.entity.egeria.ckk.Address;
import pl.kskowronski.data.entity.egeria.ckk.Client;

import java.math.BigDecimal;

@Service
public class AddressService extends CrudService<Address, BigDecimal> {

    private AddressRepo repo;

    public AddressService(@Autowired AddressRepo repo) {
        this.repo = repo;
    }

    @Override
    protected AddressRepo getRepository() {
        return repo;
    }


}

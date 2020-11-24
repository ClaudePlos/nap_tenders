package pl.kskowronski.data.service.inap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import pl.kskowronski.data.entity.inap.TenderDate;

import java.math.BigDecimal;

@Service
public class TenderDateService extends CrudService<TenderDate, BigDecimal> {

    private TenderDateRepo repo;

    public TenderDateService(@Autowired TenderDateRepo repo) {
        this.repo = repo;
    }

    @Override
    protected TenderDateRepo getRepository() {
        return repo;
    }

}

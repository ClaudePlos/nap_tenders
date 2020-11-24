package pl.kskowronski.data.service.inap;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.helpers.CrudService;
import pl.kskowronski.data.entity.inap.Tender;

import java.math.BigDecimal;

public class TenderService extends CrudService<Tender, BigDecimal> {

    private TenderRepo repo;

    public TenderService(@Autowired TenderRepo repo) {
        this.repo = repo;
    }

    @Override
    protected TenderRepo getRepository() {
        return repo;
    }
}

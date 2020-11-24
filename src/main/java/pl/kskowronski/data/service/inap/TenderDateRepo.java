package pl.kskowronski.data.service.inap;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kskowronski.data.entity.inap.TenderDate;

import java.math.BigDecimal;

public interface TenderDateRepo extends JpaRepository<TenderDate, BigDecimal> {
}

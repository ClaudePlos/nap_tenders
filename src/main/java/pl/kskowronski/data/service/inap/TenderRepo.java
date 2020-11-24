package pl.kskowronski.data.service.inap;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kskowronski.data.entity.inap.Tender;

import java.math.BigDecimal;

public interface TenderRepo extends JpaRepository<Tender, BigDecimal> {
}

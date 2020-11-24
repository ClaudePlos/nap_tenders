package pl.kskowronski.data.service.inap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kskowronski.data.entity.inap.Tender;
import pl.kskowronski.data.entity.inap.TenderDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TenderRepo extends JpaRepository<Tender, BigDecimal> {

    @Query("select t from Tender t where t.status != 'ZAKONCZONY' and t.fArchiwalny = 'N' " +
            "and id in (select td.przId from TenderDate td where td.kod = 'ZLOZENIE_OFERT' and td.data > sysdate - :numberOfDays)")
    Optional<List<Tender>> getAllTendersBeforePlacing( @Param("numberOfDays") String numberOfDays );

}

package pl.kskowronski.data.service.inap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.kskowronski.data.entity.inap.TenderOffer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TenderOfferRepo extends JpaRepository<TenderOffer, BigDecimal> {

    @Query("select to from TenderOffer to where to.przId = :przId order by to.dataZlozenia")
    Optional<List<TenderOffer>> getTendersOffersForTender(@Param("przId") BigDecimal przId);

}

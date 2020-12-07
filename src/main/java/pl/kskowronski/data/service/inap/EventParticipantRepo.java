package pl.kskowronski.data.service.inap;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kskowronski.data.entity.inap.EventParticipant;
import pl.kskowronski.data.entity.inap.TenderOffer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface EventParticipantRepo extends JpaRepository<EventParticipant, BigDecimal> {

    Optional<EventParticipant> findByOfId(BigDecimal ofId);

}

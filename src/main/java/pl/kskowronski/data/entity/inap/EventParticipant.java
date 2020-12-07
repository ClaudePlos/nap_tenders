package pl.kskowronski.data.entity.inap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "Nmkt_uczestnik_zdarzenia")
public class EventParticipant {

    @Id
    @Column(name = "id", nullable = false)
    private BigDecimal id;

    @Column(name="of_id")
    private BigDecimal ofId;

    @Column(name="kl_kod")
    private BigDecimal klKod;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getOfId() {
        return ofId;
    }

    public void setOfId(BigDecimal ofId) {
        this.ofId = ofId;
    }

    public BigDecimal getKlKod() {
        return klKod;
    }

    public void setKlKod(BigDecimal klKod) {
        this.klKod = klKod;
    }
}

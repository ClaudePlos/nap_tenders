package pl.kskowronski.data.entity.inap;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "napwf_oferta_przetargu")
public class TenderOffer {

    @Id
    @Column(name = "id", nullable = false)
    private BigDecimal id;

    @Column(name="opis")
    private String opis;

    @Column(name="data_zlozenia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataZlozenia;

    @Column(name="prz_id")
    private BigDecimal przId;

    @Column(name="kontrahent_kod")
    private BigDecimal klKod;

    @Column(name="wartosc_netto")
    private BigDecimal wartoscNetto ;

    @Column(name="wartosc_brutto")
    private BigDecimal wartoscBrutto ;

    @Column(name="status_Wyniku")
    private String statusWyniku;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(Date dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    public BigDecimal getPrzId() {
        return przId;
    }

    public void setPrzId(BigDecimal przId) {
        this.przId = przId;
    }

    public BigDecimal getKlKod() {
        return klKod;
    }

    public void setKlKod(BigDecimal klKod) {
        this.klKod = klKod;
    }

    public BigDecimal getWartoscNetto() {
        return wartoscNetto;
    }

    public void setWartoscNetto(BigDecimal wartoscNetto) {
        this.wartoscNetto = wartoscNetto;
    }

    public BigDecimal getWartoscBrutto() {
        return wartoscBrutto;
    }

    public void setWartoscBrutto(BigDecimal wartoscBrutto) {
        this.wartoscBrutto = wartoscBrutto;
    }

    public String getStatusWyniku() {
        return statusWyniku;
    }

    public void setStatusWyniku(String statusWyniku) {
        this.statusWyniku = statusWyniku;
    }
}

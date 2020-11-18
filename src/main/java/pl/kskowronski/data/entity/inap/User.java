package pl.kskowronski.data.entity.inap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "NAP_UZYTKOWNIK")
public class User {

    @Id
    @Column(name = "UZ_ID")
    private BigDecimal uzId;

    @Column(name = "PRC_ID")
    private BigDecimal prcId;

    @Column(name = "UZ_NAZWA")
    private String username;

    @Column(name = "UZ_HASLO_ZAKODOWANE")
    private String password;

    @Column(name = "UZ_STANOWISKO")
    private BigDecimal uzStanowisko;

    public BigDecimal getUzId() {
        return uzId;
    }

    public void setUzId(BigDecimal uzId) {
        this.uzId = uzId;
    }

    public BigDecimal getPrcId() {
        return prcId;
    }

    public void setPrcId(BigDecimal prcId) {
        this.prcId = prcId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getUzStanowisko() {
        return uzStanowisko;
    }

    public void setUzStanowisko(BigDecimal uzStanowisko) {
        this.uzStanowisko = uzStanowisko;
    }
}

package pl.kskowronski.data.entity.inap;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigDecimal;
import java.util.Date;

public class TenderDTO {

    private BigDecimal id;
    private Date dataOgloszenia;
    private Date dataZlozenia;
    private String status;
    private String aktywnosc;
    private String przedmiotZamowienia;
    private String typPrzetargu;
    private String formaPostepowania;
    private Long okresMc;
    private Long dlugoscUmowy;
    private Long terminPlatnosciDni;
    private String wynikOceny;
    private String progowy;
    private String responsiblePersonFormal;
    private String city;

}

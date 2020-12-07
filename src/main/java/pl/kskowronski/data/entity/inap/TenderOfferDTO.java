package pl.kskowronski.data.entity.inap;

import java.math.BigDecimal;
import java.util.Date;

public class TenderOfferDTO {

    private BigDecimal id;
    private String desc;
    private Date dateOfSubmission;
    private BigDecimal przId;
    private String client;
    private BigDecimal net ;
    private BigDecimal gross ;
    private String result;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDateOfSubmission() {
        return dateOfSubmission;
    }

    public void setDateOfSubmission(Date dateOfSubmission) {
        this.dateOfSubmission = dateOfSubmission;
    }

    public BigDecimal getPrzId() {
        return przId;
    }

    public void setPrzId(BigDecimal przId) {
        this.przId = przId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public BigDecimal getNet() {
        return net;
    }

    public void setNet(BigDecimal net) {
        this.net = net;
    }

    public BigDecimal getGross() {
        return gross;
    }

    public void setGross(BigDecimal gross) {
        this.gross = gross;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

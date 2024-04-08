package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
public class PilotPayBodyRateKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "BODY_TYPE_CODE",nullable = false,updatable = false)
    private String bodyType;

    @Column(name = "YEAR_GROUP",nullable = false,updatable = false)
    private int yrGroup;

    @Column(name = "SEAT_CD",nullable = false,updatable = false)
    private String seatCd;

    @Column(name = "VALID_FROM_TM",nullable = false,updatable = false)
    private Date validFromTm;

    @Column(name = "VALID_TO_TM",nullable = false,updatable = false)
    private Date validToTm;

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getYrGroup() {
        return yrGroup;
    }

    public void setYrGroup(int yrGroup) {
        this.yrGroup = yrGroup;
    }

    public String getSeatCd() {
        return seatCd;
    }

    public void setSeatCd(String seatCd) {
        this.seatCd = seatCd;
    }

    public Date getValidFromTm() {
        return validFromTm;
    }

    public void setValidFromTm(Date validFromTm) {
        this.validFromTm = validFromTm;
    }

    public Date getValidToTm() {
        return validToTm;
    }

    public void setValidToTm(Date validToTm) {
        this.validToTm = validToTm;
    }
}

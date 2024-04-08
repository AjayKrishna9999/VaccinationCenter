package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BidPeriodScheduleKey implements Serializable {

    private static final long serialVersionUID=1L;

    @Column(name = "BIDPERIODNUMBER", nullable = false, updatable = false)
    private int bidPeriodNumber;

    @Column(name = "BIDPERIODYEAR", nullable = false, updatable = false)
    private  int bidPeriodYear;

    @Column(name="BASESTATIONABBREV", nullable = false, updatable = false)
    private String baseStationAbbrev;

    public int getBidPeriodNumber() {
        return bidPeriodNumber;
    }

    public void setBidPeriodNumber(int bidPeriodNumber) {
        this.bidPeriodNumber = bidPeriodNumber;
    }

    public int getBidPeriodYear() {
        return bidPeriodYear;
    }

    public void setBidPeriodYear(int bidPeriodYear) {
        this.bidPeriodYear = bidPeriodYear;
    }

    public String getBaseStationAbbrev() {
        return baseStationAbbrev;
    }

    public void setBaseStationAbbrev(String baseStationAbbrev) {
        this.baseStationAbbrev = baseStationAbbrev;
    }
}

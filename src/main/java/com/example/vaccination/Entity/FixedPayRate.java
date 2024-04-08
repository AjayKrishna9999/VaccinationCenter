package com.example.vaccination.Entity;

import javax.persistence.*;

@Entity
@Table(name = "FIXED_PAY_RATE")
public class FixedPayRate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fixed_pay_rate_seq")
    @SequenceGenerator(name = "fixed_pay_rate_seq", sequenceName = "FIXED_PAY_RATE_SQ", allocationSize = 20)
    @Column(name = "FPR_ID", nullable = false, updatable = false)
    private long fprId;

    @Column(name = "FPR_PAY_REASON_CODE_NM", nullable = false, updatable = false)
    private String payReasonCd;

    @Column(name = "FPR_EFFECTIVE_START_BIDPERIOD_CYM", nullable = false, updatable = false)
    private int startBidPeriod;

    @Column(name = "FPR_EFFECTIVE_END_BIDPERIOD_CYM", nullable = false, updatable = false)
    private int endBidPeriod;

    @Column(name = "FPR_SEAT_NM", nullable = false, updatable = false)
    private String seatNm;

    @Column(name = "FPR_RATE_NBR", nullable = false, updatable = false)
    private int payRateNumber;

    public long getFprId() {
        return fprId;
    }

    public void setFprId(long fprId) {
        this.fprId = fprId;
    }

    public String getPayReasonCd() {
        return payReasonCd;
    }

    public void setPayReasonCd(String payReasonCd) {
        this.payReasonCd = payReasonCd;
    }

    public int getStartBidPeriod() {
        return startBidPeriod;
    }

    public void setStartBidPeriod(int startBidPeriod) {
        this.startBidPeriod = startBidPeriod;
    }

    public int getEndBidPeriod() {
        return endBidPeriod;
    }

    public void setEndBidPeriod(int endBidPeriod) {
        this.endBidPeriod = endBidPeriod;
    }

    public String getSeatNm() {
        return seatNm;
    }

    public void setSeatNm(String seatNm) {
        this.seatNm = seatNm;
    }

    public int getPayRateNumber() {
        return payRateNumber;
    }

    public void setPayRateNumber(int payRateNumber) {
        this.payRateNumber = payRateNumber;
    }
}

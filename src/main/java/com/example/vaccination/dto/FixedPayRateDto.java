package com.example.vaccination.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FixedPayRateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long fprId;

    private String payReasonCd;

    private int startBidPeriod;

    private int endBidPeriod;

    private String seatNm;

    private int payRateNumber;

}

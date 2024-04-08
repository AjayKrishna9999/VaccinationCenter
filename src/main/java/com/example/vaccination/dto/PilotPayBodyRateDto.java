package com.example.vaccination.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PilotPayBodyRateDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String bodyType;

    private int yrGroup;

    private String seatCd;

    private double hourlyRate;

    private Date validFromTm;

    private Date validToTm;
}

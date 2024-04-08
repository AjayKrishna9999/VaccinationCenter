package com.example.vaccination.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class PilotInfoDTO implements Serializable {

    private static final long serialVersionUID=1L;
    private String id;
    private String fName;
    private String lName;
    private int age;
    private String seatCd;
    private String baseLocation;
    private String equipmentCode;
    private Date baseTime;
    private List<DualQualDto> dualQual;
    private PilotBankDTO pilotBankDTO;
    private FedexDatesDTO fedexDatesDTO;
    private PilotContact pilotContact;
}

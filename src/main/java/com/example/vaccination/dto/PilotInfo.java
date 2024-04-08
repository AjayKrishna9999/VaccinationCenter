package com.example.vaccination.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PilotInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    protected long   id;
    protected String fName;
    protected String lName;
    protected String mi;
    protected String nName;
    protected String statusCd;
    protected String splStatusCd;
    protected Date longevityDt;
    protected Date   statusStartDt;
    protected Date   statusEndDt;
}

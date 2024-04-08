package com.example.vaccination.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class FedexDatesDTO implements Serializable {

    private final static  long serialVersionUID=1L;

    private Date payDate;
    private Date vacationDate;
    private String yrsOfService;
    private Date retirementDate;
}

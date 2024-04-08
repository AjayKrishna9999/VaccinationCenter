package com.example.vaccination.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PilotContact implements Serializable {

    private String email;
    private String primaryNumber;
    private String secondaryNumber;
    private String alternateNumber1;
    private String alternateNumber2;
    private String helpCode;
}

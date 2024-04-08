package com.example.vaccination.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PilotBankDTO implements Serializable {

    private static final long serialVersionUID=1L;

    private long rsaBalance;
    private long dsaBalance;
    private long vacBalance;
    private boolean warningLoa;
}

package com.example.vaccination.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DualQualDto implements Serializable {

    private static final long serialVersionUID=1L;

    private String equipment;
    private String seatCd;

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getSeatCd() {
        return seatCd;
    }

    public void setSeatCd(String seatCd) {
        this.seatCd = seatCd;
    }
}

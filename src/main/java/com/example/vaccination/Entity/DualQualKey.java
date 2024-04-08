package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DualQualKey implements Serializable {

    private static final long serialVersionUID=1L;

    @Column(name = "EQUIPMENT", nullable = false, updatable = false)
    private String equipment;

    @Column(name = "SEAT", nullable = false, updatable = false)
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

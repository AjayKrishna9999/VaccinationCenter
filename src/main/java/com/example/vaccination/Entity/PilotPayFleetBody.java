package com.example.vaccination.Entity;

import javax.persistence.*;

@Entity
@Table(name = "PILOT_PAY_FLEET_BODY")
public class PilotPayFleetBody {

    @Id
    @Column(name = "FLEET_CD",nullable = false, updatable = false)
    private String fleetCd;

    @Column(name = "BODY_TYPE_CODE",nullable = false, updatable = false)
    private String bodyTypeCd;


    public String getFleetCd() {
        return fleetCd;
    }

    public void setFleetCd(String fleetCd) {
        this.fleetCd = fleetCd;
    }

    public String getBodyTypeCd() {
        return bodyTypeCd;
    }

    public void setBodyTypeCd(String bodyTypeCd) {
        this.bodyTypeCd = bodyTypeCd;
    }
}

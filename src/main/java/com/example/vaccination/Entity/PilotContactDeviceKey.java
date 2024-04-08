package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PilotContactDeviceKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PILOTID", nullable = false, updatable = false)
    private String pilotId;

    @Column(name = "DEVICEADDRESS", nullable = false,updatable = false)
    private String deviceAddress;

    public String getPilotId() {
        return pilotId;
    }

    public void setPilotId(String pilotId) {
        this.pilotId = pilotId;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }
}

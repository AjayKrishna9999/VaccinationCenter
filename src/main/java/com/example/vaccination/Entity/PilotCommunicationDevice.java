package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PILOTCOMMUNICATIONDEVICE")
public class PilotCommunicationDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PilotContactDeviceKey pilotContactDeviceKey;

    @Column(name = "CONTACTRANK",updatable = false)
    private int contactRank;

    @Column(name = "AREACODE",updatable = false)
    private String areaCode;

    public PilotContactDeviceKey getPilotContactDeviceKey() {
        return pilotContactDeviceKey;
    }

    public void setPilotContactDeviceKey(PilotContactDeviceKey pilotContactDeviceKey) {
        this.pilotContactDeviceKey = pilotContactDeviceKey;
    }

    public int getContactRank() {
        return contactRank;
    }

    public void setContactRank(int contactRank) {
        this.contactRank = contactRank;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}

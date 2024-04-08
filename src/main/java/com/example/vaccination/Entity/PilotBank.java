package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Entity
@Table(name = "PILOTBANK")
public class PilotBank implements Serializable {

    @Id
    @Column(name = "PB_ID" ,updatable = false)
    private long id;

    @Column(name="PB_BANK_ABBREV" , updatable = false)
    private String bankAbbrev;

    @Column(name="PB_BALANCE" , updatable = false)
    private long minutes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBankAbbrev() {
        return bankAbbrev;
    }

    public void setBankAbbrev(String bankAbbrev) {
        this.bankAbbrev = bankAbbrev;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }
}

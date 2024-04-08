package com.example.vaccination.Entity;

import javax.persistence.*;

@Entity
@Table(name = "PILOT_PAY_BODY_RATE")
public class PilotPayBodyRate {

    @EmbeddedId
    private PilotPayBodyRateKey key;

    @Column(name = "HOURLY_RATE", nullable = false, updatable = false)
    private double hourlyRate;

    public PilotPayBodyRateKey getKey() {
        return key;
    }

    public void setKey(PilotPayBodyRateKey key) {
        this.key = key;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
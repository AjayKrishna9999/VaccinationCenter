package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CREWPOSITIONAWARD")
public class CrewPositionAward implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "ID",nullable = false,updatable = false)
    private long id;

    @Column(name = "CREWPOSITIONABBREV",nullable = false,updatable = false)
    private String crewPositionAbbrev;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCrewPositionAbbrev() {
        return crewPositionAbbrev;
    }

    public void setCrewPositionAbbrev(String crewPositionAbbrev) {
        this.crewPositionAbbrev = crewPositionAbbrev;
    }
}

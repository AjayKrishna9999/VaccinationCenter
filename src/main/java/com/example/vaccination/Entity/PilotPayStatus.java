package com.example.vaccination.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PILOTPAYSTATUS")
public class PilotPayStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID" ,updatable = false)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

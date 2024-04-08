package com.example.vaccination.Entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DUALQUAL")
public class DualQual implements Serializable {

    private static final long serialVersionUID=1L;

    @EmbeddedId
    private DualQualKey dualQualKey;

    public DualQualKey getDualQualKey() {
        return dualQualKey;
    }

    public void setDualQualKey(DualQualKey dualQualKey) {
        this.dualQualKey = dualQualKey;
    }
}

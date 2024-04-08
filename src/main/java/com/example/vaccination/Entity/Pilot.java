package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="PILOT")
public class Pilot implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @Column(name = "PILOTID" ,nullable = false,updatable = false)
    private String id;

    @Column(name= "FIRSTNAME" ,updatable = false)
    private String fName;

    @Column(name= "LASTNAME" ,updatable = false)
    private String lName;

    @Column(name="BIRTHDATE" ,updatable = false)
    private Date birthDate;

    @Column(name= "LONGEVITYDATE",updatable = false)
    private Date longrvityDt;

    @Column(name="HELPCODE" ,updatable = false)
    private String helpCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getLongrvityDt() {
        return longrvityDt;
    }

    public void setLongrvityDt(Date longrvityDt) {
        this.longrvityDt = longrvityDt;
    }

    public String getHelpCode() {
        return helpCode;
    }

    public void setHelpCode(String helpCode) {
        this.helpCode = helpCode;
    }
}

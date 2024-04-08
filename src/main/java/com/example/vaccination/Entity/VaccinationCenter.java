package com.example.vaccination.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int vaccineId;
     private String name;
     private String address;

}

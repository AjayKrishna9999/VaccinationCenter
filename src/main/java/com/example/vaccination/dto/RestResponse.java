package com.example.vaccination.dto;

import com.example.vaccination.Entity.VaccinationCenter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestResponse {

    private VaccinationCenter center;
    private List<Citizen> citizens;
}

package com.example.vaccination.controller;


import com.example.vaccination.Entity.VaccinationCenter;
import com.example.vaccination.dto.RestResponse;
import com.example.vaccination.service.VaccinationService;

//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coWin/vaccine")
@Slf4j
public class VaccinationController {

   @Autowired
   private VaccinationService service;
   
   public static final String VACCINATION_SERVICE="VaccineService";
   
   
   @PostMapping("/vaccine")
   public ResponseEntity<VaccinationCenter> register(@RequestBody VaccinationCenter vc){
	   log.info("VaccinationCenter Controller");
       return new ResponseEntity<>(service.register(vc), HttpStatus.OK);
   }

   @GetMapping("/get/{id}")
//   @CircuitBreaker(name = VACCINATION_SERVICE,fallbackMethod = "ifCitizenServiceIsDown")
   public ResponseEntity<RestResponse> getCitizensWithVaccineInfo(@PathVariable("id") int vcId){
	   log.info("VaccinationCenter Controller");
      return new ResponseEntity<>(service.getCitizensWithVaccineInfo(vcId),HttpStatus.OK);

   }
   
   public ResponseEntity<RestResponse> ifCitizenServiceIsDown(int id ,Exception e) {
		
   	RestResponse response=new RestResponse();
   	VaccinationCenter vaccine=service.findByVaccineId(id);
   	response.setCenter(vaccine);
   	return new ResponseEntity<>(response,HttpStatus.OK);
	}

}

//package com.example.vaccination.client;
//
//import java.util.List;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(name="CITIZEN-SERVICE",url = "${restPoint-url}")
//public interface CitizenServiceCall {
//
//	@GetMapping(value ="{Id}", produces = {MediaType.APPLICATION_JSON_VALUE})
//	public ResponseEntity<List<com.example.vaccination.dto.Citizen>> getByVaccination(@PathVariable("Id") int vaccinationId);
//
//}

package com.example.vaccination.service;

import com.example.vaccination.Entity.VaccinationCenter;
//import com.example.vaccination.client.CitizenServiceCall;
import com.example.vaccination.dto.Citizen;
import com.example.vaccination.dto.RestResponse;
import com.example.vaccination.repository.VaacineRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class VaccinationService {
    @Autowired
    private VaacineRepository repo;

    @Autowired
    private RestTemplate restTemplate;
    
//    @Autowired
//    private CitizenServiceCall csc;  // using Feign client
    
    

    //@Value("${restPoint-url}")
    private String url;

    public VaccinationCenter register(VaccinationCenter vc) {
    	log.info("VaccinationService Service");
        return repo.save(vc);
    }

    
    public RestResponse getCitizensWithVaccineInfo(int vcId) {
    	log.info("VaccinationService Service");
        VaccinationCenter vaccine=repo.findByVaccineId(vcId);
        RestResponse response=new RestResponse();
        response.setCenter(vaccine);
        List<Citizen> citizens=restTemplate.getForObject("http://localhost:8051/coWin/vaccine/get/"+vcId,List.class);
        response.setCitizens(citizens);
    // below lines are when using feign client.    
//        ResponseEntity<List<Citizen>> citizens1 = csc.getByVaccination(vcId);
//        response.setCitizens(citizens1.getBody());
        return response;
    }


	public VaccinationCenter findByVaccineId(int id) {
		// TODO Auto-generated method stub
		return repo.findByVaccineId(id);
	}
    
    
}

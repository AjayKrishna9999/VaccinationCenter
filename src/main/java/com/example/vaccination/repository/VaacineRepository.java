package com.example.vaccination.repository;

import com.example.vaccination.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaacineRepository extends JpaRepository<VaccinationCenter,Integer> {

	VaccinationCenter findByVaccineId(int vcId);
}

package com.example.vaccination.repository;

import com.example.vaccination.Entity.PilotPayBodyRate;
import com.example.vaccination.Entity.PilotPayBodyRateKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotPayBodyRateRepository extends JpaRepository<PilotPayBodyRate, PilotPayBodyRateKey> {

     PilotPayBodyRate findByKeyBodyTypeAndKeyYrGroupAndKeySeatCd(String bodyType,int yrGroup,String seatCd);
}

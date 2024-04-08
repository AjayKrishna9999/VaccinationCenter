package com.example.vaccination.repository;

import com.example.vaccination.Entity.FixedPayRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedPayRateRepository extends JpaRepository<FixedPayRate,Long> {

     FixedPayRate findByPayReasonCdAndSeatNm( String payReason, String seatNm);
}

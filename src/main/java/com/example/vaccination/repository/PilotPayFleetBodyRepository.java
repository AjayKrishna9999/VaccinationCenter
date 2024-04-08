package com.example.vaccination.repository;

import com.example.vaccination.Entity.PilotPayFleetBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotPayFleetBodyRepository extends JpaRepository<PilotPayFleetBody, String> {

    @Query(value = "SELECT BODY_TYPE_CODE  FROM PILOT_PAY_FLEET_BODY WHERE FLEET_CD = :fleetCd", nativeQuery = true)
     String findByFleetCd(@Param("fleetCd") String fleetCd);
}

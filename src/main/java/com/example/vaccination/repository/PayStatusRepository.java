package com.example.vaccination.repository;

import com.example.vaccination.Entity.PilotPayStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayStatusRepository extends JpaRepository<PilotPayStatus,Long> {

    @Query(value = "SELECT PAYSTATUSABBREV FROM PILOTPAYSTATUS WHERE PAYSTATUSABBREV='LOA' AND PILOTID= :pilotId",nativeQuery = true)
    List<String> getBYPilotId(@Param("pilotId") String pilotId);
}

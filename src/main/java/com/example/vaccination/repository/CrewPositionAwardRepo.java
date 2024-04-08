package com.example.vaccination.repository;

import com.example.vaccination.Entity.CrewPositionAward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewPositionAwardRepo extends JpaRepository<CrewPositionAward,Long> {

    @Query(value = "SELECT * FROM (select id,crewpositionabbrev FROM crewpositionaward where pilotid= :pilotId order by startdate desc) WHERE rownum = 1",nativeQuery = true)
    CrewPositionAward getByPilotId(@Param("pilotId") String pilotId);
}

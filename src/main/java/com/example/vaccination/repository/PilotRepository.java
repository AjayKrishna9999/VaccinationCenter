package com.example.vaccination.repository;

import com.example.vaccination.Entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotRepository extends JpaRepository<Pilot, String> {

    @Query(value = "select pilotid,firstname,lastname,birthdate,longevitydate,helpcode from pilot where pilotid=:pilotId",nativeQuery = true)
    Pilot getById(@Param("pilotId") String pilotId);

}

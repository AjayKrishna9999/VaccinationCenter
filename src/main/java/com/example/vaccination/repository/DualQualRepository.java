package com.example.vaccination.repository;

import com.example.vaccination.Entity.DualQual;
import com.example.vaccination.Entity.DualQualKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DualQualRepository extends JpaRepository<DualQual, DualQualKey> {

    @Query(value ="select equipment,seat from dualqual where pilotid= :pilotId",nativeQuery = true )
    List<DualQual> getByPilotId(@Param("pilotId") String pilotId);
}

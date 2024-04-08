package com.example.vaccination.repository;

import com.example.vaccination.Entity.PilotCommunicationDevice;
import com.example.vaccination.Entity.PilotContactDeviceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PilotConatctRepo extends JpaRepository<PilotCommunicationDevice, PilotContactDeviceKey> {

    @Query(value = "select contactrank,pilotid,deviceaddress,areacode from pilotcommunicationdevice where pilotid= :pilotId",nativeQuery = true)
    List<PilotCommunicationDevice> getPilotContacts(@Param("pilotId") String pilotId);
}

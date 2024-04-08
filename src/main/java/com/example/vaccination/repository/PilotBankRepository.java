package com.example.vaccination.repository;

import com.example.vaccination.Entity.PilotBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PilotBankRepository extends JpaRepository<PilotBank, Long> {

    @Query(value = "select pb_id,pb_bank_abbrev,pb_balance from pilotbank where pb_pilotid= :pilotId and pb_bank_abbrev in ('RSA','DSA','VAC') and pb_bank_balance_abbrev='HOURS' and pb_start_bid_period_year= :bidYear",nativeQuery = true)
    List<PilotBank> findByPilotIdAndBidYear(@Param("pilotId") String pilotId, @Param("bidYear") int bidYear);

}

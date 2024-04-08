package com.example.vaccination.repository;

import com.example.vaccination.Entity.BidPeriodSchedule;
import com.example.vaccination.Entity.BidPeriodScheduleKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BidPeriodScheduleRepo extends JpaRepository<BidPeriodSchedule, BidPeriodScheduleKey> {

    @Query(value = "select SCHEDULEDBIDAYBASESTARTTIME from bidperiodschedule where bidperiodnumber=:bidMonth and bidperiodyear=:bidYear and basestationabbrev=:base",nativeQuery = true)
    Date getBaseStartDate(@Param("bidMonth") int bidMonth,@Param("bidYear") int bidYear,@Param("base") String base);
}

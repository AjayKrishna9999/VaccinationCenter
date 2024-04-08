package com.example.vaccination.service;

import com.example.vaccination.dto.FixedPayRateDto;
import com.example.vaccination.dto.PilotInfo;
import com.example.vaccination.exception.CrewPayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
@Slf4j
public class PilotPayRateImpl implements PilotPayRateCalc {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PilotPayMapper pilotPayMapper;


    @Value("${pilot.lookup}")
    private String pilotInfoUrl;


    @Override
    //@Async
    public long getPayRate(long pilotId, String equipmentNumber, String seatType) throws CrewPayException {
        return this.getHourlyRate(pilotId, new Date(), equipmentNumber, seatType);
    }

    @Override
//    @Async
    public long getPayRate(long pilotId, Date activityDt, String equipmentNumber, String seatType) throws CrewPayException {
        return this.getHourlyRate(pilotId, activityDt, equipmentNumber, seatType);
    }

    @Override
    public long getPay(long pilotId, long creditMins, Date activityDt, String equipmentNumber, String seatType) throws CrewPayException {
        long payRate = this.getPayRate(pilotId, activityDt, equipmentNumber, seatType);
        return Math.round(payRate * (creditMins / 60));
    }

    @Override
    public long getPay(long pilotId, long creditMins, Date activityDt, String equipmentNumber, String seatType, double percentage) {
        long payRate = this.getPayRate(pilotId, activityDt, equipmentNumber, seatType);
        return Math.round((creditMins / 60) * (percentage / 100) * payRate);
    }

    @Override
    public long getPay(long pilotId, long creditMins, Date activityDt, String equipmentNumber, String seatType, String payReason) {
        PilotInfo pilotInfo = restTemplate.getForObject(pilotInfoUrl + pilotId, PilotInfo.class);
        if (pilotInfo != null) {
            FixedPayRateDto fixedPayRateDto = pilotPayMapper.getFixedPayRate(payReason, seatType);
            if (fixedPayRateDto != null && payReason.equals(fixedPayRateDto.getPayReasonCd())) {
                log.info("PayReason: " + fixedPayRateDto.getPayReasonCd() + " fixedPay: " + fixedPayRateDto.getPayRateNumber());
                return Math.round((creditMins / 60) * fixedPayRateDto.getPayRateNumber());
            } else {
                return this.getPay(pilotId, creditMins, activityDt, equipmentNumber, seatType);
            }
        } else {
            throw new EntityNotFoundException("No Pilot Data find for PilotId: " + pilotId);
        }
    }

    @Override
    public long getPay(long pilotId, long creditMins, Date activityDt, String equipmentNumber, String seatType, String payReason, double percentage) {
        long pay = this.getPay(pilotId, creditMins, activityDt, equipmentNumber, seatType, payReason);
        return Math.round(pay * (percentage / 100));
    }

//    @Async
    private long getHourlyRate(long pilotId, Date activityDt, String equipmentNumber, String seatType) throws CrewPayException {
        String bodyType = pilotPayMapper.getBodyType(equipmentNumber);
        int yearGroup = this.getYearGroup(pilotId, activityDt);
        return pilotPayMapper.getHourlyRate(bodyType, yearGroup, seatType);
    }

//    @Async
    private int getYearGroup(long pilotId, Date activityDt) throws CrewPayException {
        PilotInfo pilotInfo = restTemplate.getForObject(pilotInfoUrl + pilotId, PilotInfo.class);
        if (pilotInfo != null) {
            log.info(pilotInfo.toString());
            LocalDate date1 = pilotInfo.getLongevityDt().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate date2 = activityDt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            return (int) ChronoUnit.YEARS.between(LocalDate.of(date1.getYear(), date1.getMonth(), date1.getDayOfMonth()),
                    LocalDate.of(date2.getYear(), date2.getMonth(), date2.getDayOfMonth()));
        } else {
            throw new CrewPayException("No Pilot Data find for PilotId: " + pilotId);
        }

    }
}

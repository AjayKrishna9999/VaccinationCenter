package com.example.vaccination.service;

import com.example.vaccination.Entity.FixedPayRate;
import com.example.vaccination.Entity.PilotPayBodyRate;
import com.example.vaccination.dto.FixedPayRateDto;
import com.example.vaccination.dto.PilotPayBodyRateDto;
import com.example.vaccination.repository.FixedPayRateRepository;
import com.example.vaccination.repository.PilotPayBodyRateRepository;
import com.example.vaccination.repository.PilotPayFleetBodyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


@Component
public class PilotPayMapper {

    @Autowired
    private PilotPayFleetBodyRepository pilotPayFleetBodyRepository;

    @Autowired
    private PilotPayBodyRateRepository pilotPayBodyRateRepository;

    @Autowired
    private FixedPayRateRepository fixedPayRateRepository;

    //@Cacheable("bodyType")
    public String getBodyType(String fleetCd) {
        return pilotPayFleetBodyRepository.findByFleetCd(fleetCd);
    }

    //@Cacheable("hourlyRate")
    public long getHourlyRate(String bodyType, int yrGroup, String seatCd) {
        PilotPayBodyRate pilotPayBodyRate=pilotPayBodyRateRepository.findByKeyBodyTypeAndKeyYrGroupAndKeySeatCd(bodyType,yrGroup,seatCd);
        if(pilotPayBodyRate != null){
            PilotPayBodyRateDto pilotPayBodyRateDto=new PilotPayBodyRateDto();
            this.pilotPayBodyRateMapper(pilotPayBodyRate, pilotPayBodyRateDto);
            return Math.round(pilotPayBodyRateDto.getHourlyRate());
        }
        return 0;

    }

    private void pilotPayBodyRateMapper(PilotPayBodyRate pilotPayBodyRate,PilotPayBodyRateDto pilotPayBodyRateDto){
        pilotPayBodyRateDto.setBodyType(pilotPayBodyRate.getKey().getBodyType());
        pilotPayBodyRateDto.setYrGroup(pilotPayBodyRate.getKey().getYrGroup());
        pilotPayBodyRateDto.setHourlyRate(pilotPayBodyRate.getHourlyRate());
        pilotPayBodyRateDto.setSeatCd(pilotPayBodyRate.getKey().getSeatCd());
    }

    public FixedPayRateDto getFixedPayRate(String payReason, String seatCd) {
        FixedPayRate fixedPayRate = fixedPayRateRepository.findByPayReasonCdAndSeatNm(payReason, seatCd);
        if (fixedPayRate != null) {
            FixedPayRateDto fixedPayRatedto = new FixedPayRateDto();
            fixedPayRatedto.setFprId(fixedPayRate.getFprId());
            fixedPayRatedto.setPayReasonCd(fixedPayRate.getPayReasonCd());
            fixedPayRatedto.setStartBidPeriod(fixedPayRate.getStartBidPeriod());
            fixedPayRatedto.setEndBidPeriod(fixedPayRate.getEndBidPeriod());
            fixedPayRatedto.setSeatNm(fixedPayRate.getSeatNm());
            fixedPayRatedto.setPayRateNumber(fixedPayRate.getPayRateNumber());
            return fixedPayRatedto;
        }
        return null;
    }
}

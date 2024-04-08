package com.example.vaccination.service;

import com.example.vaccination.Entity.*;
import com.example.vaccination.dto.*;
import com.example.vaccination.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
//import java.time.Period;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PilotInfoService {

    @Autowired
    private PilotRepository pilotRepository;

    @Autowired
    private PilotBankRepository pilotBankRepository;

    @Autowired
    private PilotConatctRepo pilotConatctRepo;

    @Autowired
    private PayStatusRepository payStatusRepository;

    @Autowired
    private DualQualRepository dualQualRepository;

    @Autowired
    private CrewPositionAwardRepo crewPositionAwardRepo;

    @Autowired
    private BidPeriodScheduleRepo bidPeriodScheduleRepo;

    public PilotInfoDTO getPilotInfoDTO(String pilotId, int bidYear, int bidMonth) {
        Pilot pilot = pilotRepository.getById(pilotId);
        List<PilotBank> pilotBank = pilotBankRepository.findByPilotIdAndBidYear(pilotId, bidYear);
        List<PilotCommunicationDevice> devices = pilotConatctRepo.getPilotContacts(pilotId);
        List<String> payStatus = payStatusRepository.getBYPilotId(pilotId);
        CrewPositionAward crewPositionAward = crewPositionAwardRepo.getByPilotId(pilotId);
        PilotInfoDTO pilotInfoDTO = this.pilotInfoMapper(pilot, pilotBank, devices, payStatus);
        pilotInfoDTO.setBaseLocation(crewPositionAward.getCrewPositionAbbrev().substring(0, 3));
        pilotInfoDTO.setEquipmentCode(crewPositionAward.getCrewPositionAbbrev().substring(3, 5));
        pilotInfoDTO.setSeatCd(crewPositionAward.getCrewPositionAbbrev().substring(5));
        Date baseStartTime=bidPeriodScheduleRepo.getBaseStartDate(bidMonth,bidYear,pilotInfoDTO.getBaseLocation());
        pilotInfoDTO.setBaseTime(baseStartTime);
        List<DualQual> dualQuals = dualQualRepository.getByPilotId(pilotId);
        List<DualQualDto> dualQualDtos = new ArrayList<>();
        dualQuals.forEach(a -> {
            DualQualDto dualQualDto = new DualQualDto();
            dualQualDto.setEquipment(a.getDualQualKey().getEquipment());
            dualQualDto.setSeatCd(a.getDualQualKey().getSeatCd());
            dualQualDtos.add(dualQualDto);
        });
        pilotInfoDTO.setDualQual(dualQualDtos);
        return pilotInfoDTO;
    }

    private PilotInfoDTO pilotInfoMapper(Pilot pilot, List<PilotBank> pilotBank, List<PilotCommunicationDevice> devices, List<String> payStatus) {
        PilotInfoDTO pilotInfoDTO = new PilotInfoDTO();
        PilotBankDTO pilotBankDTO = new PilotBankDTO();
        PilotContact pilotContact = new PilotContact();
        FedexDatesDTO fedexDatesDTO=new FedexDatesDTO();
        pilotInfoDTO.setId(pilot.getId());
        pilotInfoDTO.setFName(pilot.getfName());
        pilotInfoDTO.setLName(pilot.getlName());
        pilotInfoDTO.setAge(this.calculateAge(pilot.getBirthDate()));
        fedexDatesDTO.setYrsOfService(this.yrsOfService(new Date(), pilot.getLongrvityDt()));
        pilotInfoDTO.setFedexDatesDTO(fedexDatesDTO);
        pilotContact.setHelpCode(pilot.getHelpCode());
        pilotBank.forEach(a -> {
            if (a.getBankAbbrev().equals("RSA")) {
                pilotBankDTO.setRsaBalance(a.getMinutes());
            } else if (a.getBankAbbrev().equals("DSA")) {
                pilotBankDTO.setDsaBalance(a.getMinutes());
            } else {
                pilotBankDTO.setVacBalance(a.getMinutes());
            }
        });
        pilotBankDTO.setWarningLoa(!payStatus.isEmpty());
        pilotInfoDTO.setPilotBankDTO(pilotBankDTO);
        devices.forEach(a -> {
            if (a.getContactRank() == 1) {
                pilotContact.setPrimaryNumber("(" + a.getAreaCode() + ")" + a.getPilotContactDeviceKey().getDeviceAddress());
            } else if (a.getContactRank() == 2) {
                pilotContact.setSecondaryNumber("(" + a.getAreaCode() + ")" + a.getPilotContactDeviceKey().getDeviceAddress());
            } else if (a.getContactRank() == 3) {
                pilotContact.setAlternateNumber1("(" + a.getAreaCode() + ")" + a.getPilotContactDeviceKey().getDeviceAddress());
            } else {
                pilotContact.setAlternateNumber2("(" + a.getAreaCode() + ")" + a.getPilotContactDeviceKey().getDeviceAddress());
            }
        });
        pilotInfoDTO.setPilotContact(pilotContact);
        return pilotInfoDTO;
    }

    private int calculateAge(Date birthDate) {
        LocalDate dateOfBirth = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        log.info("BIRTH DATE: " + birthDate);
        log.info("DATE OF BIRTH: " + dateOfBirth);
        LocalDate now = LocalDate.now();
        log.info("Now: " + now);
        return (int) ChronoUnit.YEARS.between(dateOfBirth, now);
    }

    private String yrsOfService(Date activityDate, Date joiningDate) {

        LocalDate activeDate = activityDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate joinDate = joiningDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int years = (int) ChronoUnit.YEARS.between(joinDate, activeDate);
        int months = (int) ChronoUnit.MONTHS.between(joinDate, activeDate) % 12;
//        int months = Period.between(joinDate,activeDate).getMonths();
        return years + "y" + " " + months + "mo";
    }

}

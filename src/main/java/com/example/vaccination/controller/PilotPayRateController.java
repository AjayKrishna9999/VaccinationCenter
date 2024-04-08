package com.example.vaccination.controller;

import com.example.vaccination.exception.CrewPayException;
import com.example.vaccination.service.PilotPayRateCalc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Validated
@RestController
@RequestMapping("/payrate")
@Slf4j
public class PilotPayRateController {

    @Autowired
    private PilotPayRateCalc pilotPayRateCalc;

    private final static List<String> SEAT_CD = Arrays.asList("CAP", "F/0", "S/O");

    private final static List<String> FLEET_CODE=Arrays.asList("A-300", "A-300/310", "A-310", "ANC11", "ANC77", "B737", "B747", "B757", "B767", "B767F", "B777",
            "B-777F", "B787", "DC-10", "6EUR57", "HKG30", "HKG67", "IND67", "LAX11", "MD-10", "MD-10/11", "MD-11", "MEM10", "MEM11", "MEM27", "MEM30", "MEM57",
            "MEM67", "MEM77", "OAK67", "SFS30");

    @GetMapping("")
    public ResponseEntity<Long> getPay(@RequestParam(name = "pilotId") long pilotId,
                                       @RequestParam(name = "creditMins", required = false) Long creditMins,
                                       @RequestParam(name = "activityDt", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date activityDt,
                                       @RequestParam(name = "equipmentNumber") String equipmentNumber,
                                       @RequestParam(name = "seatType") String seatType,
                                       @RequestParam(name = "payReason", required = false) String payReason,
                                       @RequestParam(name = "percentage", defaultValue = "100", required = false) Double percentage) throws CrewPayException {


        System.out.println("Start Time:"+ Calendar.getInstance().getTime());
        if (FLEET_CODE.contains(equipmentNumber) && SEAT_CD.contains(seatType)) {
            if (creditMins != null) {
                if (payReason != null) {
                    return new ResponseEntity<>(pilotPayRateCalc.getPay(pilotId, creditMins, activityDt, equipmentNumber, seatType, payReason, percentage), HttpStatus.OK);
                }
                System.out.println("Start Time:"+ Calendar.getInstance().getTime());
                return new ResponseEntity<>(pilotPayRateCalc.getPay(pilotId, creditMins, activityDt, equipmentNumber, seatType, percentage), HttpStatus.OK);
            }
            if (activityDt != null) {
                return new ResponseEntity<>(pilotPayRateCalc.getPayRate(pilotId, activityDt, equipmentNumber, seatType), HttpStatus.OK);
            } else {
                System.out.println("Start Time:"+ Calendar.getInstance().getTime());
                return new ResponseEntity<>(pilotPayRateCalc.getPayRate(pilotId, equipmentNumber, seatType), HttpStatus.OK);
            }
        } else {
            throw new IllegalArgumentException("FleetCode: "+equipmentNumber+" or SeatCode: "+seatType+" is not Valid");
        }
    }
}

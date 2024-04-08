package com.example.vaccination.controller;

import com.example.vaccination.dto.PilotInfoDTO;
import com.example.vaccination.service.PilotInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilotData")
@Slf4j
public class PilotInfoController {

    @Autowired
    private PilotInfoService pilotInfoService;

    @GetMapping("/get")
    public ResponseEntity<PilotInfoDTO> getPilotInfoDTO(@RequestParam(name = "pilotId") String pilotId,
                                                        @RequestParam(name = "bidYear") Integer bidYear,
                                                        @RequestParam(name="bidMonth") Integer bidMonth){
        log.info("Controller");
        PilotInfoDTO pilotInfoDTO=this.pilotInfoService.getPilotInfoDTO(pilotId,bidYear,bidMonth);
        if(pilotInfoDTO != null){
            return new ResponseEntity<>(pilotInfoDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
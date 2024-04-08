package com.example.vaccination.service;
import com.example.vaccination.exception.CrewPayException;

import java.util.Date;

public interface PilotPayRateCalc {

     long getPayRate(long pilotId, String equipmentNumber, String seatType) throws CrewPayException;

     long getPayRate(long pilotId, Date activityDt, String equipmentNumber, String seatType) throws CrewPayException;

     long getPay(long pilotId, long creditMins, Date activityDt, String equipmentNumber, String seatType ) throws CrewPayException;

     long getPay(long pilotId, long creditMins, Date activityDt, String equipmentNumber, String seatType, double percentage );

     long getPay(long pilotId, long creditMins, Date activityDt, String equipmentNumber, String seatType, String payReason);

     long getPay(long pilotId, long creditMins, Date activityDt, String equipmentNumber, String seatType, String payReason, double percentage);
}
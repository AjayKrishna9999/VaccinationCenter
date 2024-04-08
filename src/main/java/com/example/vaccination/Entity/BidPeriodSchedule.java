package com.example.vaccination.Entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BIDPERIODSCHEDULE")
public class BidPeriodSchedule implements Serializable {

    private static final long serialVersionUID=1L;

    @EmbeddedId
    private BidPeriodScheduleKey bidPeriodScheduleKey;


    @Column(name = "SCHEDULEDBIDAYBASESTARTTIME", updatable = false)
    private Date baseStartDate;

    public BidPeriodScheduleKey getBidPeriodScheduleKey() {
        return bidPeriodScheduleKey;
    }

    public void setBidPeriodScheduleKey(BidPeriodScheduleKey bidPeriodScheduleKey) {
        this.bidPeriodScheduleKey = bidPeriodScheduleKey;
    }

    public Date getBaseStartDate() {
        return baseStartDate;
    }

    public void setBaseStartDate(Date baseStartDate) {
        this.baseStartDate = baseStartDate;
    }
}

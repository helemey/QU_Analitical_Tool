package com.model.dataType.Line;

import java.util.Date;

public class WaitingTimeLine extends GeneralRequest {
    private Date date;
    private int time;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public int getTime() {
        return time;
    }
}

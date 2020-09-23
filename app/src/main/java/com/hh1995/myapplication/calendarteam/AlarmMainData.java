package com.hh1995.myapplication.calendarteam;

public class AlarmMainData {
    private String tv_date;
    private String tv_schedule;

    public AlarmMainData(String tv_date, String tv_schedule) {
        this.tv_date = tv_date;
        this.tv_schedule = tv_schedule;
    }

    public String getTv_date() {
        return tv_date;
    }

    public void setTv_date(String tv_date) {
        this.tv_date = tv_date;
    }

    public String getTv_schedule() {
        return tv_schedule;
    }

    public void setTv_schedule(String tv_schedule) {
        this.tv_schedule = tv_schedule;
    }
}



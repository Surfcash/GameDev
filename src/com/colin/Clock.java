package com.colin;

import processing.core.PApplet;

public class Clock {

    private int days, hours, minutes, seconds, tick;

    public Clock(int hour, int minute, int second) {
        setHours(hour);
        setMinutes(minute);
        setSeconds(second);
    }

    public Clock(String str) {
        setTime(str);
    }

    public int getDays() {
        return days;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getTick() {
        return tick;
    }

    public void setDays(int num) {
        days = num;
    }

    public void setHours(int num) {
        if(num >= 24) {
            addDays(num / 24);
            num = num % 24;
        }
        hours = num;
    }

    public void setMinutes(int num) {
        if(num >= 60) {
            addHours(num / 60);
            num = num % 60;
        }
        minutes = num;
    }

    public void setSeconds(int num) {
        if(num >= 60) {
            addMinutes(num / 60);
            num = num % 60;
        }
        seconds = num;
    }

    public void setTick(int num) {
        tick = num;
    }

    public void setTime(String str) {
        String[] time = PApplet.split(str, ":");
        setHours(Integer.parseInt(time[0]));
        if(time.length > 1) {
            setMinutes(Integer.parseInt(time[1]));
        }
        if(time.length > 2) {
            setSeconds(Integer.parseInt(time[2]));
        }
    }

    public void addDays(int num) {
        setDays(getDays() + num);
    }

    public void addHours(int num) {
        setHours(getHours() + num);
    }

    public void addMinutes(int num) {
        setMinutes(getMinutes() + num);
    }

    public void addSeconds(int num) {
        setSeconds(getSeconds() + num);
    }

    @Override
    public String toString() {
        return getHours() + ":" + (getMinutes() < 10 ? "0" + getMinutes(): getMinutes()) + ":" + (getSeconds() < 10 ? "0" + getSeconds(): getSeconds());
    }
}

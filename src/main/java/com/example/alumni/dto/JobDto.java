package com.example.alumni.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class JobDto {
    private String title;
    private String company;
    private String details;
    private LocalDateTime timeStamp;
    private String applyLink;
    private LocalDate lastDate;
    private String location;

    public JobDto() {
    }

    public JobDto(String title, String company, String details, String applyLink, LocalDate lastDate, LocalDateTime timeStamp, String location) {
        this.title = title;
        this.company = company;
        this.details = details;
        this.applyLink = applyLink;
        this.lastDate = lastDate;
        this.timeStamp = timeStamp;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getApplyLink() {
        return applyLink;
    }

    public void setApplyLink(String applyLink) {
        this.applyLink = applyLink;
    }

    public LocalDate getLastDate() {
        return lastDate;
    }

    public void setLastDate(LocalDate lastDate) {
        this.lastDate = lastDate;
    }
    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }
}

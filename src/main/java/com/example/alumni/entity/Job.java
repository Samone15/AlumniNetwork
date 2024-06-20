package com.example.alumni.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private LocalDateTime timeStamp;

    @Column(nullable = false)
    private String applyLink;

    @Column(nullable = false)
    private LocalDate lastDate;

    
    @Column(nullable = false)
    private String location;

    public Job(){

    }

    public Job(String title, String company, String details, String applyLink, LocalDate lastdate, LocalDateTime timeStamp, String location){
        this.title = title;
        this.company = company;
        this.details = details;
        this.applyLink = applyLink;
        this.lastDate = lastdate;
        this.timeStamp = timeStamp;
        this.location = location;
    }

    public Long getJobId(){
        return this.jobId;
    }

    public String getTitle(){
        return this.title;
    }

    public String getCompany(){
        return this.company;
    }

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    public String getDetails(){
        return this.details;
    }

    public LocalDateTime getTimeStamp(){
        return this.timeStamp;
    }

    public String getApplyLink(){
        return this.applyLink;
    }

    public LocalDate getLasDate(){
        return this.lastDate;
    }

    public void setJobId(Long jobId){
        this.jobId = jobId;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public void setDetails(String details){
        this.details = details;
    }

    public void setTimeStamp(LocalDateTime timeStamp){
        this.timeStamp = timeStamp;
    }

    public void setLastdate(LocalDate lasDate){
        this.lastDate = lasDate;
    }

    public void setApplyLink(String applyLink){
        this.applyLink = applyLink;
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }
}

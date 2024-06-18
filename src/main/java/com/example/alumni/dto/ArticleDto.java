package com.example.alumni.dto;

import java.time.LocalDateTime;

public class ArticleDto {
    String title;
    String description;
    LocalDateTime timeStamp;

    public ArticleDto(){

    }

    public ArticleDto(String title, String description, LocalDateTime now){
        this.title = title;
        this.description = description;
        this.timeStamp = now;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }

    public LocalDateTime getTimeStamp(){
        return this.timeStamp;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setTimeStamp(LocalDateTime timeStamp){
        this.timeStamp = timeStamp;
    }
    
}

package com.example.alumni.dto;

import java.time.LocalDateTime;
import java.util.List;

public class QuestionDto {
    String title;
    String description;
    LocalDateTime timeStamp;
    UserDto userDto;
    List<AnswerDto> answers;
    
    public QuestionDto(){

    }

    public QuestionDto(String title, String description, LocalDateTime timeStamp, UserDto userDto, List<AnswerDto> answers){
        this.title = title;
        this.description = description;
        this.timeStamp = timeStamp;
        this.userDto = userDto;
        this.answers = answers;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public LocalDateTime getTimeStamp(){
        return this.timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp){
        this.timeStamp = timeStamp;
    }

    public UserDto getUser(){
        return this.userDto;
    }

    public void setUser(UserDto userDto){
        this.userDto = userDto;
    }

    public List<AnswerDto> getAnswers(){
        return this.answers;
    }

    public void setAnswers(List<AnswerDto> answers){
        this.answers = answers;
    }
}

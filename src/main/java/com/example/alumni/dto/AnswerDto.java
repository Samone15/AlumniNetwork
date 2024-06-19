package com.example.alumni.dto;

import java.time.LocalDateTime;

public class AnswerDto {
    String reply;
    LocalDateTime timeStamp;
    UserDto user;
    QuestionDto question;

    public AnswerDto(){

    }

    public AnswerDto(String reply, LocalDateTime timeStamp, UserDto userDto, QuestionDto questionDto){
        this.reply = reply;
        this.timeStamp = timeStamp;
        this.user = userDto;
        this.question = questionDto;
    }

    public String getReply(){
        return this.reply;
    }

    public void setReply(String reply){
        this.reply = reply;
    }

    public LocalDateTime getTimeStamp(){
        return this.timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp){
        this.timeStamp = timeStamp;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto userDto) {
        this.user = userDto;
    }

    public QuestionDto getQuestion(){
        return this.question;
    }

    public void setQuestion(QuestionDto questionDto){
        this.question = questionDto;
    }
}

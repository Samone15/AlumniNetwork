package com.example.alumni.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(nullable = false)
    private String reply;

    @Column(nullable = false)
    private LocalDateTime timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    public Answer(){

    }

    public Answer(String reply, LocalDateTime timeStamp, User user, Question question){
        this.reply = reply;
        this.timeStamp = timeStamp;
        this.user = user;
        this.question = question;
    }

    public Long getReplyId(){
        return this.replyId;
    }

    public void setReplyId(Long replyId){
        this.replyId = replyId;
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

    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public Question getQuestion(){
        return this.question;
    }

    public void setQuestion(Question question){
        this.question = question;
    }
    
}

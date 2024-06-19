package com.example.alumni.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Answer> answers;

    public Question(){

    }

    public Question(String title, String description, LocalDateTime timeStamp, User user, List<Answer> answers){
        this.title = title;
        this.description = description;
        this.timeStamp = timeStamp;
        this.user = user;
        this.answers = answers;
    }

    public Long getQuestionId(){
        return this.questionId;
    }

    public void setQuestionId(Long questionId){
        this.questionId = questionId;
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
    
    public User getUser(){
        return this.user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public List<Answer> getAnswers(){
        return this.answers;
    }

    public void setAnswers(List<Answer> answers){
        this.answers = answers;
    }
}

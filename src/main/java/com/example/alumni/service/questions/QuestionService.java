package com.example.alumni.service.questions;

import java.util.List;

import com.example.alumni.dto.AnswerDto;
import com.example.alumni.dto.QuestionDto;
import com.example.alumni.entity.Question;

public interface QuestionService {
    List<Question> getTopNQuestions(int limit);
    Question saveQuestion(QuestionDto questionDto);
    void addAnswerToQuestion(Long questionId, AnswerDto answerDto);
}


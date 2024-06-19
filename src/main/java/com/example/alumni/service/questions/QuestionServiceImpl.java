package com.example.alumni.service.questions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.alumni.dto.AnswerDto;
import com.example.alumni.dto.QuestionDto;
import com.example.alumni.entity.Answer;
import com.example.alumni.entity.Question;
import com.example.alumni.entity.User;
import com.example.alumni.repository.AnswerRepository;
import com.example.alumni.repository.QuestionRepository;
import com.example.alumni.repository.UserRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository, UserRepository userRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Question> getTopNQuestions(int limit) {
        return questionRepository.topNQuestions(limit);
    }

    @Override
    public Question saveQuestion(QuestionDto questionDto) {
        questionDto.setTimeStamp(LocalDateTime.now());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Optional<User> optionalUser = userRepository.findByUsername(userDetails.getUsername());
            
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();
                List<Answer> answers = new ArrayList<>(); 
                Question question = new Question(questionDto.getTitle(), questionDto.getDescription(), questionDto.getTimeStamp(), user, answers);
                return questionRepository.save(question);
            } else {
                throw new IllegalArgumentException("User with username " + userDetails.getUsername() + " not found");
            }
        } else {
            throw new IllegalStateException("User is not authenticated or authentication principal is of unexpected type");
        }
    }

    @Override
    public void addAnswerToQuestion(Long questionId, AnswerDto answerDto) {
        Question question = questionRepository.findById(questionId)
            .orElseThrow(() -> new IllegalArgumentException("Question not found"));
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

            Answer answer = new Answer(answerDto.getReply(), LocalDateTime.now(), user, question);
            answerRepository.save(answer);
        } else {
            throw new IllegalStateException("User is not authenticated");
        }
    }
}

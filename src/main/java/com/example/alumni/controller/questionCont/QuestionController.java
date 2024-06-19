package com.example.alumni.controller.questionCont;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.alumni.dto.AnswerDto;
import com.example.alumni.dto.QuestionDto;
import com.example.alumni.entity.Question;
import com.example.alumni.service.questions.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/top")
    public String getTopQuestions(Model model, @RequestParam(defaultValue = "10") int limit) {
        List<Question> questions = questionService.getTopNQuestions(limit);
        model.addAttribute("questions", questions);
        return "questionsPage";
    }

    @PostMapping
    public String addQuestion(@ModelAttribute QuestionDto questionDto) {
        questionService.saveQuestion(questionDto);
        return "redirect:/questions/top";
    }

    @PostMapping("/{questionId}/answers")
    public String addAnswer(@PathVariable Long questionId, @ModelAttribute AnswerDto answerDto) {
        questionService.addAnswerToQuestion(questionId, answerDto);
        return "redirect:/questions/top";
    }
}

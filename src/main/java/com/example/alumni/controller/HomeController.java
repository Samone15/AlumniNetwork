package com.example.alumni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.alumni.entity.Article;
import com.example.alumni.service.articles.ArticleService;

@Controller
public class HomeController {

    private final ArticleService articleService;

    @Autowired
    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/home")
    public String getTopArticles(Model model, @RequestParam(value = "limit", defaultValue = "10") int limit){
        List<Article> articles = articleService.getTopNArticles(limit);
        model.addAttribute("articles", articles);
        return "index";
    }
}

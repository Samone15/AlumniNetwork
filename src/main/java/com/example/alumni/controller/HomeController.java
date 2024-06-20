package com.example.alumni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/topArticles")
    public String getTopArticles(Model model, @RequestParam(value = "limit", defaultValue = "10") int limit){
        List<Article> articles = articleService.getTopNArticles(limit);
        model.addAttribute("articles", articles);
        return "topArticles";
    }

    @GetMapping("/article/{id}")
    public String getArticleById(@PathVariable Long id, Model model) {
        Article article = articleService.findById(id);
        model.addAttribute("article", article);
        return "articleDetail";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/jobPage")
    public String jobPage(Model model) {
        return "jobPage";
    }


}

package com.example.alumni.controller.articleCont;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.alumni.dto.ArticleDto;
import com.example.alumni.entity.Article;
import com.example.alumni.service.articles.ArticleService;



@Controller
@RequestMapping("/articles")
public class ArticleController {
    
    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/write")
    public String showWriteArticleForm(Model model) {
        model.addAttribute("article", new ArticleDto());
        return "writeArticle";
    }

    @PostMapping("/create")
    public String createArticle(@ModelAttribute("article") ArticleDto articleDto) {
        articleService.saveArticle(articleDto);
        return "redirect:/articles/write?success=true";
    }

}

package com.example.alumni.service.articles;

import java.util.List;

import com.example.alumni.dto.ArticleDto;
import com.example.alumni.entity.Article;

public interface ArticleService {
    List<Article> getTopNArticles(int limit);
    Article saveArticle(ArticleDto articleDto);
}

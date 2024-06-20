package com.example.alumni.service.articles;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.alumni.dto.ArticleDto;
import com.example.alumni.entity.Article;
import com.example.alumni.repository.ArticleRepository;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getTopNArticles(int limit) {
        List<Article> articles =  articleRepository.findTopNByOrderByTimeStampDesc(limit);
        return articles.stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public Article saveArticle(ArticleDto articleDto) {
        articleDto.setTimeStamp(LocalDateTime.now());
        Article article = new Article(articleDto.getTitle(), articleDto.getDescription(), articleDto.getTimeStamp());
        return articleRepository.save(article);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Article not found"));
    }
}

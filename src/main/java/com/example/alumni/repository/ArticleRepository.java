package com.example.alumni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.alumni.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

    @Query(value = "SELECT * FROM articles ORDER BY time_stamp DESC LIMIT :n", nativeQuery = true)
    List<Article> findTopNByOrderByTimeStampDesc(@Param("n") int n);

    Optional<Article> findById(Long articleId);

}

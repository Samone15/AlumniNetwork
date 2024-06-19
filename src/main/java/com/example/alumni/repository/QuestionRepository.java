package com.example.alumni.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.alumni.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
    @Query(value = "SELECT * FROM questions ORDER BY time_stamp DESC LIMIT :limit", nativeQuery = true)
    List<Question> topNQuestions(int limit);

    Optional<Question> findById(Long id);
}


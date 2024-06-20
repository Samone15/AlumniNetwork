package com.example.alumni.repository;


import com.example.alumni.entity.Job;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long>{
    
    @Query(value = "SELECT * FROM jobs ORDER BY time_stamp DESC LIMIT :n", nativeQuery = true)
    List<Job> topNJobAlerts(@Param("n") int n);

    @Query("SELECT j FROM Job j WHERE j.lastDate <= :lastDate ORDER BY j.lastDate DESC")
    List<Job> findTopNJobsByLastDate(@Param("lastDate") LocalDate lastDate, Pageable pageable);
}

package com.example.alumni.service.jobs;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import com.example.alumni.dto.JobDto;
import com.example.alumni.entity.Job;
import com.example.alumni.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{

    private final JobRepository jobRepository;

    @Autowired
    public JobServiceImpl(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getTopNJobs(int limit) {
        return jobRepository.topNJobAlerts(limit);
    }

    @Override
    public Job saveJob(JobDto jobDto) {
        jobDto.setTimeStamp(LocalDateTime.now());
        Job job = new Job(jobDto.getTitle(), jobDto.getCompany(), jobDto.getDetails(), jobDto.getApplyLink(),jobDto.getLastDate(), 
        jobDto.getTimeStamp(), jobDto.getLocation());
        return jobRepository.save(job);
    }
    
    @Override
    public List<Job> getJobsByLastDate(int n, LocalDate lastDate) {
        Pageable pageable = PageRequest.of(0, n);
        return jobRepository.findTopNJobsByLastDate(lastDate, pageable);
    }
}

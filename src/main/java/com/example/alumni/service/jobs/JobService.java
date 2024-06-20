package com.example.alumni.service.jobs;

import java.time.LocalDate;
import java.util.List;

import com.example.alumni.dto.JobDto;
import com.example.alumni.entity.Job;

public interface JobService {
    List<Job> getTopNJobs(int limit);
    Job saveJob(JobDto jobDto);
    List<Job> getJobsByLastDate(int limit, LocalDate lasDate);
}

package com.example.alumni.service.jobs;

import java.util.List;

import com.example.alumni.dto.JobDto;
import com.example.alumni.entity.Job;

public interface JobService {
    List<Job> getTopNJobs(int limit);
    Job saveJob(JobDto jobDto);
}

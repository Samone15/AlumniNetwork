package com.example.alumni.controller.jobCont;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.alumni.dto.JobDto;
import com.example.alumni.entity.Job;
import com.example.alumni.service.jobs.JobService;

@Controller
@RequestMapping("/jobs")
public class JobController {
    
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/write")
    public String jobForm(Model model){
        model.addAttribute("jobDto", new JobDto());
        return "writeJob";
    }

    @PostMapping("/create")
    public String jobSubmit(@ModelAttribute("jobDto") JobDto jobDto){
        jobService.saveJob(jobDto);
        return "redirect:/home?success=true";
    }

    @GetMapping("/job-alerts")
    public String topJobAlerts(Model model, @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<Job> jobs = jobService.getTopNJobs(limit);
        model.addAttribute("jobs", jobs);
        return "jobPage";
    }

    @GetMapping("/top")
    public String getTopNJobsByLastDate(
            @RequestParam("n") int n,
            @RequestParam("lastDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastDate,
            Model model) {
        List<Job> jobs = jobService.getJobsByLastDate(n, lastDate);
        model.addAttribute("jobs", jobs);
        return "topJobs"; 
    }
}

package com.kapil.jobscheduler.controller;

import com.kapil.jobscheduler.model.JobRequest;
import com.kapil.jobscheduler.model.ScheduledJob;
import com.kapil.jobscheduler.service.JobSchedulerService;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobSchedulerService jobSchedulerService;

    @PostMapping
    public ResponseEntity<String> scheduleJob(@RequestBody JobRequest request) {
        jobSchedulerService.scheduleJob(request);
        return ResponseEntity.ok("Job scheduled: " + request.getName());
    }
    
    @GetMapping
    public ResponseEntity<List<ScheduledJob>> getAllJobs() {
        return ResponseEntity.ok(jobSchedulerService.getAllJobs());
    }
    
    @DeleteMapping("/{name}")
    public ResponseEntity<String> cancelJob(@PathVariable String name) {
        boolean removed = jobSchedulerService.cancelJob(name);
        if (removed) {
            return ResponseEntity.ok("Job canceled: " + name);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
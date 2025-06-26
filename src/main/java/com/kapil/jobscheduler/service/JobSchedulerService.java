package com.kapil.jobscheduler.service;

import com.kapil.jobscheduler.model.JobRequest;
import com.kapil.jobscheduler.model.ScheduledJob;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class JobSchedulerService {
    private final PriorityQueue<ScheduledJob> jobQueue = new PriorityQueue<>();

    public void scheduleJob(JobRequest request) {
        long scheduledTime = System.currentTimeMillis() + request.getDelaySeconds() * 1000L;
        ScheduledJob job = new ScheduledJob(request.getName(), scheduledTime, request.getPriority());
        synchronized (jobQueue) {
            jobQueue.offer(job);
        }
    }

    @PostConstruct
    public void startScheduler() {
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            long now = System.currentTimeMillis();
            synchronized (jobQueue) {
                while (!jobQueue.isEmpty() && jobQueue.peek().getScheduledTime() <= now) {
                    ScheduledJob job = jobQueue.poll();
                    System.out.println("Executed job: " + job.getName());
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }
    
    public List<ScheduledJob> getAllJobs() {
        synchronized (jobQueue) {
            return new ArrayList<>(jobQueue);
        }
    }
    
    public boolean cancelJob(String name) {
        synchronized (jobQueue) {
            return jobQueue.removeIf(job -> job.getName().equalsIgnoreCase(name));
        }
    }


}

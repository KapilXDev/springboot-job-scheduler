package com.kapil.jobscheduler.model;

import lombok.Data;

@Data
public class JobRequest {
    private String name;
    private int delaySeconds;
    private int priority;
}
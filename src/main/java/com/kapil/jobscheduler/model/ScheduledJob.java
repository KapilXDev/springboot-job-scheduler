package com.kapil.jobscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScheduledJob implements Comparable<ScheduledJob> {
    private String name;
    private long scheduledTime;
    private int priority;

    @Override
    public int compareTo(ScheduledJob other) {
        return Long.compare(this.scheduledTime, other.scheduledTime);
    }
}
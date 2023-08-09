package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.Sleep;
import lombok.*;

import java.sql.Time;
import java.time.Instant;

@Getter
@Setter
@Builder
public class SleepDTO {
    private Long sleepID;
    private Instant sleepStartTime;
    private Instant sleepEndTime;
    private Time sleepDuration;
    private Sleep.SleepType sleepType;
    private String sleepEnvironment;
    private String sleepQuality;
    private String sleepNotes;
    private Long babyId;
}

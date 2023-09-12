package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.Reminder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;
import java.time.LocalTime;
import java.time.LocalDate;

@Getter
@Setter
public class ReminderDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderID;
    private String title;
    private String reminderType;
    private String date;
    private String time;
    private String ringingFrequency;     //"once"  "keep ringing"
    private String repeatFrequency;      //"daily" "weekly" "monthly" "yearly"







}

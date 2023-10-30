package com.example.CuddleCare.dto;


import com.example.CuddleCare.entity.Diaper;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.Instant;

@Getter
@Setter
public class DiaperDTO {
    private Long diaperID;
    private Instant date;
    private Time time;
    private String diaper_type;
    private Diaper.Humidity humidity;
    private String stool_color;
    private String additionalNotes;
}

package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.BreastFeeding;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

public class BreastFeedingDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long breastFeedingID;

    private String feedingDuration;
    private Date feedingDate;
    private String starttime;
    private String endtime;
    private String side;
//    private Baby baby;
}

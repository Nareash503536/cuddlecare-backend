package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.Baby;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter

public class BottleFeedingDTO {


    private Long bottleFeedingID;
    private String feedingTime;
    private Date feedingDate;
    private String feedingType;
    private String quantity;
//    private Baby baby;
}

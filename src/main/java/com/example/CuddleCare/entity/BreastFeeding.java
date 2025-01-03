package com.example.CuddleCare.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "breastfeeding")
public class BreastFeeding {

//    private enum Side{
//        Left,
//        Right
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breast_feeding_ID", nullable = false)
    private Long breastFeedingID;



    @Basic
    @Column(name = "feeding_duration")
    private String feedingDuration;

    @Basic
    @Column(name = "feeding_day")
    private Date feedingDate;
    @Basic
    @Column(name = "Start_time")
    private String starttime;
    @Basic
    @Column(name = "end_time")
    private String endtime;
    @Basic
    @Column(name = "feeding_side")
    private String side;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    @JsonManagedReference
    private Baby baby;

}

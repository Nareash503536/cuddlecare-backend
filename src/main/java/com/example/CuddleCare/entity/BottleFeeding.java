package com.example.CuddleCare.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "bottlefeeding")
public class BottleFeeding {

//    private enum Side{
//        Left,
//        Right
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bottle_feedingID", nullable = false)
    private Long bottleFeedingID;

    @Basic
    @Column(name = "feeding_time")
    private String feedingTime;
    @Basic
    @Column(name = "feeding_date")
    private Date feedingDate;
    @Basic
    @Column(name = "feedingtype")
    private String feedingType;
    @Basic
    @Column(name = "quantity")
    private String quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    @JsonBackReference
    private Baby baby;

}

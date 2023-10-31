package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "feeding")
public class Feeding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feeding_ID", nullable = false)
    private Long feedingID;

    private enum FeedingTypes{
        BreastFeeding,
        BottleFeeding,
        FoodFeeding
    }

    @Basic
    @Column(name = "feeding_type")
    private FeedingTypes feedingType;

    @Basic
    @Column(name = "time")
    private Time time;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "reaction") //There should be a reaction enum
    private String reaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feeding feeding = (Feeding) o;
        return Objects.equals(feedingID, feeding.feedingID) && feedingType == feeding.feedingType && Objects.equals(time, feeding.time) && Objects.equals(date, feeding.date) && Objects.equals(reaction, feeding.reaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedingID, feedingType, time, date, reaction);
    }
}

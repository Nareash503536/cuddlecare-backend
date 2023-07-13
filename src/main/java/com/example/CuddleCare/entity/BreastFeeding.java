package com.example.CuddleCare.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "breast_feeding")
public class BreastFeeding {

    private enum Side{
        Left,
        Right
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breast_feeding_ID", nullable = false)
    private Long breastFeedingID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BreastFeeding that = (BreastFeeding) o;
        return Objects.equals(breastFeedingID, that.breastFeedingID) && Objects.equals(feedingDuration, that.feedingDuration) && side == that.side && Objects.equals(additionalNotes, that.additionalNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(breastFeedingID, feedingDuration, side, additionalNotes);
    }

    @Basic
    @Column(name = "feeding_duration")
    private String feedingDuration;

    @Basic
    @Column(name = "side")
    private Side side;

    @Basic
    @Column(name = "additional_notes")
    private String additionalNotes;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feeding_id", referencedColumnName = "feeding_id")
    private Feeding feeding;

}

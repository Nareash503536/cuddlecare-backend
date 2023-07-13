package com.example.CuddleCare.entity;

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
@Table(name = "milestone")
public class Milestone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "milestone_ID", nullable = false)
    private Long milestoneID;

    @Basic
    @Column(name = "milestone_type")
    private String milestoneType;

    @Basic
    @Column(name = "milestone_date")
    private Date milestoneDate;

    @Basic
    @Column(name = "milestone_details")
    private String milestoneDetails;

    @Basic
    @Column(name = "milestone_assesment")
    private String milestoneAssessment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Milestone milestone = (Milestone) o;
        return Objects.equals(milestoneID, milestone.milestoneID) && Objects.equals(milestoneType, milestone.milestoneType) && Objects.equals(milestoneDate, milestone.milestoneDate) && Objects.equals(milestoneDetails, milestone.milestoneDetails) && Objects.equals(milestoneAssessment, milestone.milestoneAssessment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(milestoneID, milestoneType, milestoneDate, milestoneDetails, milestoneAssessment);
    }
}

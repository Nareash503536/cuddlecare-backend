package com.example.CuddleCare.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "baby")
public class Baby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baby_ID", nullable = false)
    private Long babyID;

    @Basic
    @Column(name = "baby_Name", nullable = false, unique = true)
    private String babyName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baby baby = (Baby) o;
        return Objects.equals(babyID, baby.babyID) && Objects.equals(babyName, baby.babyName) && Objects.equals(babyDOB, baby.babyDOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(babyID, babyName, babyDOB);
    }

    @Basic
    @Column(name = "baby_DOB", nullable = false)
    private Date babyDOB;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caregiver_id", referencedColumnName = "caregiver_id")
    private Caregiver caregiver;

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Symptom> symptoms = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Sleep> sleepSet = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Milestone> milestoneSet = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<GrowthMeasurement> growthMeasurements = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Expense> expenses = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Diaper> diaperSet = new HashSet<>();

    @OneToMany(mappedBy = "baby", cascade = CascadeType.ALL)
    private Set<Feeding> feedings = new HashSet<>();

    @OneToMany(mappedBy = "baby")
    private Set<ToDoList> toDoLists = new HashSet<>();

    @ManyToMany(mappedBy = "babies")
    private Set<Parents> parents = new HashSet<>();
}
package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sleep")
public class Sleep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sleep_ID", nullable = false)
    private Long sleepID;

    private enum SleepType{Nap, NightSleep}

    @Basic
    @Column(name = "sleep_start_time")
    private Time sleepStartTime;

    @Basic
    @Column(name = "sleep_end_time")
    private Time sleepEndTime;

    @Basic
    @Column(name = "sleep_type")
    private SleepType sleepType;

    @Basic
    @Column(name = "sleep_environment")
    private String sleepEnvironment;

    @Basic
    @Column(name = "sleep_quality")
    private String sleepQuality;

    @Basic
    @Column(name = "sleep_notes")
    private String sleepNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sleep sleep = (Sleep) o;
        return Objects.equals(sleepID, sleep.sleepID) && Objects.equals(sleepStartTime, sleep.sleepStartTime) && Objects.equals(sleepEndTime, sleep.sleepEndTime) && sleepType == sleep.sleepType && Objects.equals(sleepEnvironment, sleep.sleepEnvironment) && Objects.equals(sleepQuality, sleep.sleepQuality) && Objects.equals(sleepNotes, sleep.sleepNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sleepID, sleepStartTime, sleepEndTime, sleepType, sleepEnvironment, sleepQuality, sleepNotes);
    }
}

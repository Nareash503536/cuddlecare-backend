package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "reminder")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminder_id", nullable = false)
    private Long reminderID;

    private enum reminderTypes{
        Milestone,
        Personal,
        Vaccine
    }


    @Basic
    @Column(name = "reminder_type")
    private reminderTypes reminderType;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "time")
    private Time time;

    @Basic
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "parent_id")
    private Parents parent;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return Objects.equals(reminderID, reminder.reminderID) && reminderType == reminder.reminderType && Objects.equals(date, reminder.date) && Objects.equals(time, reminder.time) && Objects.equals(description, reminder.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reminderID, reminderType, date, time, description);
    }
}

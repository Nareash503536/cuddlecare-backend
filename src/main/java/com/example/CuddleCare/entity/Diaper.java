package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "diaper")
public class Diaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diaper_ID", nullable = false)
    private Long diaperID;

    public enum Humidity{Dry, Wet}

    @Basic
    @Column(name = "date", nullable = false)
    private Instant date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diaper diaper = (Diaper) o;
        return Objects.equals(diaperID, diaper.diaperID) && Objects.equals(date, diaper.date) && Objects.equals(time, diaper.time) && Objects.equals(diaper_type, diaper.diaper_type) && humidity == diaper.humidity && Objects.equals(stool_color, diaper.stool_color) && Objects.equals(additionalNotes, diaper.additionalNotes);
    }

    @Basic
    @Column(name = "time", nullable = false)
    private Time time;

    @Basic
    @Column(name = "diaper_type")
    private String diaper_type; // Need to change the type later

    @Basic
    @Column(name = "humidity", nullable = false)
    private Humidity humidity;

    @Basic
    @Column(name = "stool_color", nullable = false)
    private String stool_color;  // Need to change the type later

    @Basic
    @Column(name = "additional_note")
    private String additionalNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;

    @Override
    public int hashCode() {
        return Objects.hash(diaperID, date, time, diaper_type, humidity, stool_color, additionalNotes);
    }
}

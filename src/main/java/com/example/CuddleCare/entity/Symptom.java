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
@Builder
@Entity
@Table(name = "symptom")
public class Symptom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symptom_ID", nullable = false)
    private Long symptomID;

    private enum symptomSet{
        NoNegativeSymptoms,
        GeneralFussiness,
        Rash,
        RunnyNose,
        Cough,
        Fever,
        AbnormalBreathing,
        LowEnergy,
        NoAppetite,
        SpitUp,
        Vomiting
    }

    @Basic
    @Column(name = "symptom_type")
    private symptomSet symptomType;

    @Basic
    @Column(name = "symptom_desc")
    private String symptomDescription;

    @Basic
    @Column(name = "date")
    private Date date;

    @Basic
    @Column(name = "time")
    private Time time;

    @Basic
    @Column(name = "additional_notes")
    private String additionalNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symptom symptom = (Symptom) o;
        return Objects.equals(symptomID, symptom.symptomID) && symptomType == symptom.symptomType && Objects.equals(symptomDescription, symptom.symptomDescription) && Objects.equals(date, symptom.date) && Objects.equals(time, symptom.time) && Objects.equals(additionalNotes, symptom.additionalNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symptomID, symptomType, symptomDescription, date, time, additionalNotes);
    }
}

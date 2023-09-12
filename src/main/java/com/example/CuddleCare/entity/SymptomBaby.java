package com.example.CuddleCare.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "symptom_baby")
public class SymptomBaby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "symptom_baby_ID", nullable = false)
    private Long symptomBabyID;

    @Basic
    @Column(name = "date")
    private String date;

    @Basic
    @Column(name = "time")
    private String time;

    @Basic
    @Column(name = "additional_notes")
    private String additionalNotes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symptom_id", referencedColumnName = "symptom_id")
    private Symptom symptom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "baby_id", referencedColumnName = "baby_id")
    private Baby baby;
}

package com.example.CuddleCare.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class SymptomBabyDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long symptomBabyID;
    private String date;
    private String time;
    private String additionalNotes;
    private SymptomDTO symptom;
    private BabyDTO baby;

    public void setSymptom(SymptomDTO symptomDTO){
        this.symptom = symptomDTO;
    }

    public void setBaby(BabyDTO babyDTO){
        this.baby = babyDTO;
    }

}

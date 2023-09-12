package com.example.CuddleCare.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class SymptomDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long symptomID;

    private String name;
}

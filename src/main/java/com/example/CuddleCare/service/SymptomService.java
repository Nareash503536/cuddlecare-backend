package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.SymptomBabyDTO;
import com.example.CuddleCare.dto.SymptomDTO;
import com.example.CuddleCare.entity.Symptom;
import com.example.CuddleCare.entity.SymptomBaby;

import java.util.List;

public interface SymptomService {
    Symptom createSymptom(String name);
    SymptomBaby loadSymptomBabyByID(Long id);
    SymptomBabyDTO createSymptomBaby(SymptomBabyDTO symptomBabyDTO);
    SymptomBabyDTO updateSymptomBaby(SymptomBabyDTO symptomBabyDTO);
    void removeSymptomBaby(Long id);
    SymptomDTO loadSymptomByName(String name);
    List<SymptomBabyDTO> loadSymptomBabyByDate(String date, Long babyID);
    boolean  ifSymptomBabyExistsOnDate(String date, Long babyID);
    List<String> loadDistinctDatesByBaby(Long babyID);
}

package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.SymptomDTO;
import com.example.CuddleCare.entity.Symptom;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SymptomMapper {
    public Symptom FromSymptomDto(SymptomDTO symptomDto) {
        Symptom symptom = new Symptom();
        BeanUtils.copyProperties(symptomDto, symptom);
        return symptom;
    }

    public SymptomDTO FromSymptom(Symptom symptom) {
        SymptomDTO symptomDto = new SymptomDTO();
        BeanUtils.copyProperties(symptom, symptomDto);
        return symptomDto;
    }
}



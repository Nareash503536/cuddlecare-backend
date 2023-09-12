package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.SymptomBabyDTO;
import com.example.CuddleCare.entity.SymptomBaby;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class SymptomBabyMapper {

    private SymptomMapper symptomMapper;
    private BabyMapper babyMapper;

    public SymptomBabyMapper(
            SymptomMapper symptomMapper,
            BabyMapper babyMapper
    ) {
        this.symptomMapper = symptomMapper;
        this.babyMapper = babyMapper;
    }

    public SymptomBaby FromSymptomBabyDto(SymptomBabyDTO symptomBabyDto) {
        SymptomBaby symptomBaby = new SymptomBaby();
        BeanUtils.copyProperties(symptomBabyDto, symptomBaby);
        symptomBaby.setSymptom(symptomMapper.FromSymptomDto(symptomBabyDto.getSymptom()));
        symptomBaby.setBaby(babyMapper.FromBabyDto(symptomBabyDto.getBaby()));
        return symptomBaby;
    }

    public SymptomBabyDTO FromSymptomBaby(SymptomBaby symptomBaby) {
        SymptomBabyDTO symptomBabyDto = new SymptomBabyDTO();
        BeanUtils.copyProperties(symptomBaby, symptomBabyDto);
        symptomBabyDto.setSymptom(symptomMapper.FromSymptom(symptomBaby.getSymptom()));
        symptomBabyDto.setBaby(babyMapper.FromBaby(symptomBaby.getBaby()));
        return symptomBabyDto;
    }

}

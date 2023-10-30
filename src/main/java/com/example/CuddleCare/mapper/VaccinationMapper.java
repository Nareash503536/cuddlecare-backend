package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.VaccinationDTO;
import com.example.CuddleCare.entity.Vaccination;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class VaccinationMapper {

    public BabyMapper babyMapper;

    VaccinationMapper(
            BabyMapper babyMapper
    ) {
        this.babyMapper = babyMapper;
    }


    public Vaccination FromVaccinationDto(VaccinationDTO vaccinationDto) {
        // TODO Auto-generated constructor stub
        Vaccination vaccination = new Vaccination();
        BeanUtils.copyProperties(vaccinationDto, vaccination);
        vaccination.setBabies(vaccinationDto.getBabies().stream().map(
                babyDto -> babyMapper.FromBabyDto(babyDto)
        ).collect(Collectors.toSet()));
        return vaccination;
    }

    public VaccinationDTO FromVaccination(Vaccination vaccination) {
        // TODO Auto-generated constructor stub
        VaccinationDTO vaccinationDto = new VaccinationDTO();
        BeanUtils.copyProperties(vaccination, vaccinationDto);
        vaccinationDto.setBabies(vaccination.getBabies().stream().map(
                baby -> babyMapper.FromBaby(baby)
        ).collect(Collectors.toSet()));
        return vaccinationDto;
    }
}

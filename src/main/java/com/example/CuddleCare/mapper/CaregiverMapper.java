package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.entity.Caregiver;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CaregiverMapper{

    private UserMapper userMapper;
    private BabyMapper babyMapper;

    CaregiverMapper(
            UserMapper userMapper,
            BabyMapper babyMapper
    ){

        this.userMapper = userMapper;
        this.babyMapper = babyMapper;
    }
    
    public CaregiverDTO FromCaregiver(Caregiver caregiver){
        CaregiverDTO caregiverDto = new CaregiverDTO();
        BeanUtils.copyProperties(caregiver, caregiverDto);
        caregiverDto.setUser(userMapper.FromUser(caregiver.getUser()));
        caregiverDto.setBabies(caregiver.getBabies().stream().map(baby -> babyMapper.FromBaby(baby)).collect(Collectors.toSet()));
        caregiverDto.setRequestedBabies(caregiver.getRequestedBabies().stream().map(baby -> babyMapper.FromBaby(baby)).collect(Collectors.toSet()));
        return caregiverDto;
    }

    public Caregiver FromCaregiverDto(CaregiverDTO caregiverDto){
        Caregiver caregiver = new Caregiver();
        BeanUtils.copyProperties(caregiverDto, caregiver);
        caregiver.setUser(userMapper.FromUserDto(caregiverDto.getUser()));
        caregiver.setBabies(caregiverDto.getBabies().stream().map(baby -> babyMapper.FromBabyDto(baby)).collect(Collectors.toSet()));
        caregiver.setRequestedBabies(caregiverDto.getRequestedBabies().stream().map(baby -> babyMapper.FromBabyDto(baby)).collect(Collectors.toSet()));
        return caregiver;
    }
}
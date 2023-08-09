package com.example.CuddleCare.mapper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.entity.Caregiver;

@Service
public class CaregiverMapper{

    private UserMapper userMapper;

    CaregiverMapper(UserMapper userMapper){
        this.userMapper = userMapper;
    }
    
    public CaregiverDTO FromCaregiver(Caregiver caregiver){
        CaregiverDTO caregiverDto = new CaregiverDTO();
        BeanUtils.copyProperties(caregiver, caregiverDto);
        caregiverDto.setUser(userMapper.FromUser(caregiver.getUser()));
        return caregiverDto;
    }

    public Caregiver FromCaregiverDto(CaregiverDTO caregiverDto){
        Caregiver caregiver = new Caregiver();
        BeanUtils.copyProperties(caregiverDto, caregiver);
        caregiver.setUser(userMapper.FromUserDto(caregiverDto.getUser()));
        return caregiver;
    }
}
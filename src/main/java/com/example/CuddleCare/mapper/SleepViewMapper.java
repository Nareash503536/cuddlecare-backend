package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.SleepViewDTO;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SleepViewMapper {
    public SleepViewDTO toDTO(Object[] result) {
        SleepViewDTO dto = new SleepViewDTO();
        dto.setDate((String) result[0]);
        dto.setSleepDuration((BigInteger) result[1]);
        return dto;
    }
}

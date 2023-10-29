package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.DiaperViewDTO;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class DiaperViewMapper {
    public DiaperViewDTO toDTO(Object[] result){
        DiaperViewDTO dto = new DiaperViewDTO();
        dto.setDate((String) result[0]);
        dto.setCount((BigInteger) result[1]);
        return dto;
    }
}

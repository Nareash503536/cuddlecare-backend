package com.example.CuddleCare.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.entity.Baby;

@Service
public class BabyMapper {

    private ParentMapper parentMapper;

    BabyMapper(ParentMapper parentMapper) {
        this.parentMapper = parentMapper;
    }

    public BabyDTO FromBaby(Baby baby) {
        BabyDTO babyDto = new BabyDTO();
        BeanUtils.copyProperties(baby, babyDto);
        babyDto.setParents(
            baby.getParents().stream()
                .map(parent -> parentMapper.FromParent(parent))
                .collect(Collectors.toSet())
        );
        return babyDto;
    }

    public Baby FromBabyDto(BabyDTO babyDto) {
        Baby baby = new Baby();
        BeanUtils.copyProperties(babyDto, baby);
        baby.setParents(
            babyDto.getParents().stream()
                .map(parentDto -> parentMapper.FromParentDto(parentDto))
                .collect(Collectors.toSet())
        );
        return baby;
    }
}

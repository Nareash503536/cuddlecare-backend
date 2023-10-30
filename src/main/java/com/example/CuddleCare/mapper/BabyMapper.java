package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.entity.Baby;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class BabyMapper {

    private ParentMapper parentMapper;
//    private CaregiverMapper caregiverMapper;

    BabyMapper(
            ParentMapper parentMapper
//            CaregiverMapper caregiverMapper
    ) {
//        this.caregiverMapper = caregiverMapper;
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
//        babyDto.setRequestCaregiverSet(
//                baby.getRequestCaregiverSet().stream()
//                        .map(caregiver -> caregiverMapper.FromCaregiver(caregiver))
//                        .collect(Collectors.toSet())
//        );
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
//        baby.setRequestCaregiverSet(
//                babyDto.getRequestCaregiverSet().stream()
//                        .map(caregiverDto -> caregiverMapper.FromCaregiverDto(caregiverDto))
//                        .collect(Collectors.toSet())
//        );
        return baby;
    }
}

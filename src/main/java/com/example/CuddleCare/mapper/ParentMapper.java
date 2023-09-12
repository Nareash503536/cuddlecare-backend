package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Parents;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ParentMapper {

    private UserMapper userMapper;
//    private BabyMapper babyMapper;

    ParentMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
//        this.babyMapper = babyMapper;
    }
    public Parents FromParentDto(ParentDTO parentDto) {
        Parents parent = new Parents();
        BeanUtils.copyProperties(parentDto, parent);
        parent.setUser(userMapper.FromUserDto(parentDto.getUser()));
//        Set<BabyDTO> BabyDtoSet = parentDto.getBabies();
//        Set<Baby> BabySet = BabyDtoSet.stream().map(BabyDto -> babyMapper.FromBabyDto(BabyDto)).collect(Collectors.toSet()); ;
//        parent.setBabies(BabySet);
        return parent;
    }

    public ParentDTO FromParent(Parents parent) {
        ParentDTO parentDto = new ParentDTO();
        BeanUtils.copyProperties(parent, parentDto);
        parentDto.setUser(userMapper.FromUser(parent.getUser()));
//        Set<Baby> BabySet = parent.getBabies();
//        Set<BabyDTO> BabyDtoSet = BabySet.stream().map(Baby -> babyMapper.FromBaby(Baby)).collect(Collectors.toSet()); ;
//        parentDto.setBabies(BabyDtoSet);
        return parentDto;
    }
}

package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Parents;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ParentMapper {

    private UserMapper userMapper;

    ParentMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    public Parents FromParentDto(ParentDTO parentDto) {
        Parents parent = new Parents();
        BeanUtils.copyProperties(parentDto, parent);
        parent.setUser(userMapper.FromUserDto(parentDto.getUser()));
        return parent;
    }

    public ParentDTO FromParent(Parents parent) {
        ParentDTO parentDto = new ParentDTO();
        BeanUtils.copyProperties(parent, parentDto);
        parentDto.setUser(userMapper.FromUser(parent.getUser()));
        return parentDto;
    }
}

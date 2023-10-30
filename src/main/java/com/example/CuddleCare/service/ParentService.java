package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Parents;
import com.example.CuddleCare.entity.User;

public interface ParentService {
    ParentDTO createParentDTO(ParentDTO parentDTO);
    Parents loadParentByUser(User user);
    ParentDTO loadParentDTOByUser(User user);
    Parents loadParentById(Long parentId);
    ParentDTO assignParentRole(ParentDTO parentDTO);
}

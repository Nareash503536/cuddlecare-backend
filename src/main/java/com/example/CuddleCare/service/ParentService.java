package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.entity.Parents;

public interface ParentService {
    ParentDTO createParent(ParentDTO parentDTO);
    ParentDTO loadParentByUser(User user);
    Parents loadParentById(Long parentId);
    ParentDTO assignParentRole(ParentDTO parentDTO);
}

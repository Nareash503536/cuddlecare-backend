package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.ParentDao;
import com.example.CuddleCare.dao.UserDao;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Parents;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.mapper.ParentMapper;
import com.example.CuddleCare.service.ParentService;
import com.example.CuddleCare.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ParentServiceImpl implements ParentService {

    private UserService userService;
    private ParentMapper parentMapper;
    private UserDao userDao;
    private ParentDao parentDao;

    public ParentServiceImpl(UserService userService,
                             ParentMapper parentMapper,
                             UserDao userDao,
                             ParentDao parentDao){
        this.userService = userService;
        this.parentMapper = parentMapper;
        this.userDao = userDao;
        this.parentDao = parentDao;
    }
    @Override
    public ParentDTO createParent(ParentDTO parentDTO) {
        User user = userService.createUser(parentDTO.getUser());
        userService.AssignRoleToUser(user.getEmail(), "Parent");
        Parents parent = parentMapper.FromParentDto(parentDTO);
        parent.setUser(user);
        Parents savedParent = parentDao.save(parent);
        return parentMapper.FromParent(savedParent);
    }
    @Override
    public ParentDTO loadParentByUser(User user) {
        return parentMapper.FromParent(parentDao.findByUser(user));
    }
    @Override
    public Parents loadParentById(Long parentId) {
        // TODO Auto-generated method stub
        return parentDao.findByParentID(parentId);
    }

    @Override
    public ParentDTO assignParentRole(ParentDTO parentDTO) {
        User user = userService.loadUserByEmail(parentDTO.getUser().getEmail());
        userService.AssignRoleToUser(user.getEmail(), "Parent");
        Parents parent = parentMapper.FromParentDto(parentDTO);
        parent.setUser(user);
        Parents savedParent = parentDao.save(parent);
        return parentMapper.FromParent(savedParent);
    }
}
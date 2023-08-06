package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.CaregiverDao;
import com.example.CuddleCare.dao.UserDao;
import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.entity.Caregiver;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.mapper.CaregiverMapper;
import com.example.CuddleCare.mapper.UserMapper;
import com.example.CuddleCare.service.CaregiverService;
import com.example.CuddleCare.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class CaregiverServiceImpl implements CaregiverService {

    private CaregiverMapper caregiverMapper;
    private CaregiverDao caregiverDao;
    private UserDao userDao;
    private UserMapper userMapper;
    private UserService userService;    

    public CaregiverServiceImpl(CaregiverMapper caregiverMapper,
            CaregiverDao caregiverDao,
            UserMapper userMapper,
            UserDao userDao,
            UserService userService) {
        this.caregiverMapper = caregiverMapper;
        this.caregiverDao = caregiverDao;
        this.userMapper = userMapper;
        this.userDao = userDao;
        this.userService = userService;
    }

    @Override
    public CaregiverDTO createCaregiver(CaregiverDTO caregiverDTO) {
        User user = userService.createUser(caregiverDTO.getUser());
        userService.AssignRoleToUser(user.getEmail(), "Caregiver");
        Caregiver caregiver = caregiverMapper.FromCaregiverDto(caregiverDTO);
        caregiver.setUser(user);
        Caregiver savedCaregiver = caregiverDao.save(caregiver);
        return caregiverMapper.FromCaregiver(savedCaregiver);
    }

    @Override
    public CaregiverDTO assignCaregiverRole(CaregiverDTO caregiverDTO) {
        User user = userService.loadUserByEmail(caregiverDTO.getUser().getEmail());
        userService.AssignRoleToUser(user.getEmail(), "Caregiver");
        Caregiver caregiver = caregiverMapper.FromCaregiverDto(caregiverDTO);
        caregiver.setUser(user);
        Caregiver savedCaregiver = caregiverDao.save(caregiver);
        return caregiverMapper.FromCaregiver(savedCaregiver);
    }



}

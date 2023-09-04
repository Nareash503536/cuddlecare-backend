package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.CaregiverDao;
import com.example.CuddleCare.dao.UserDao;
import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.entity.Caregiver;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.mapper.BabyMapper;
import com.example.CuddleCare.mapper.CaregiverMapper;
import com.example.CuddleCare.mapper.UserMapper;
import com.example.CuddleCare.service.CaregiverService;
import com.example.CuddleCare.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class CaregiverServiceImpl implements CaregiverService {

    private CaregiverMapper caregiverMapper;
    private CaregiverDao caregiverDao;
    private UserDao userDao;
    private UserMapper userMapper;
    private UserService userService;
    private BabyMapper babyMapper;

    public CaregiverServiceImpl(CaregiverMapper caregiverMapper,
            CaregiverDao caregiverDao,
            UserMapper userMapper,
            UserDao userDao,
            UserService userService,
            BabyMapper babyMapper) {
        this.caregiverMapper = caregiverMapper;
        this.caregiverDao = caregiverDao;
        this.userMapper = userMapper;
        this.userDao = userDao;
        this.userService = userService;
        this.babyMapper = babyMapper;
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

//    @Override
//    public List<BabyDTO> loadBabiesByCaregiver(User user) {
//        Caregiver caregiver = caregiverDao.findCaregiverByUser(user);
//        List<BabyDTO> babies = caregiver.getBabies().stream().map(baby -> babyMapper.FromBaby(baby)).toList();
//        return babies;
//    }


}

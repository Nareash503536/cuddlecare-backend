package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.BabyDao;
import com.example.CuddleCare.dao.CaregiverDao;
import com.example.CuddleCare.dao.UserDao;
import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Caregiver;
import com.example.CuddleCare.entity.User;
import com.example.CuddleCare.mapper.CaregiverMapper;
import com.example.CuddleCare.service.CaregiverService;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class CaregiverServiceImpl implements CaregiverService {

    private CaregiverMapper caregiverMapper;
    private CaregiverDao caregiverDao;
    private BabyDao babyDao;
    private UserDao userDao;
    private UserService userService;

    public CaregiverServiceImpl(CaregiverMapper caregiverMapper,
                                CaregiverDao caregiverDao,
                                UserDao userDao,
                                UserService userService,
                                BabyDao babyDao
                                ) {
        this.caregiverMapper = caregiverMapper;
        this.caregiverDao = caregiverDao;
        this.userDao = userDao;
        this.userService = userService;
        this.babyDao = babyDao;
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

    @Override
    public Caregiver loadCaregiverById(Long id) {
        return caregiverDao.findByCaregiverID(id);
    }

    @Override
    public Set<Baby> loadBabiesByCaregiver(String email) {
        Caregiver caregiver = caregiverDao.findCaregiverByUser(userDao.findByEmail(email));
        return caregiver.getBabies();
    }

    @Override
    public Caregiver updateCaregiver(Caregiver caregiver) {
        return caregiverDao.save(caregiver);
    }

    @Override
    public List<CaregiverDTO> getCaregiverList() {
        List<Caregiver> caregiverList = caregiverDao.findAll();
        List<CaregiverDTO> CaregiverDtoSet = caregiverList.stream().map(caregiver -> caregiverMapper.FromCaregiver(caregiver)).toList();
        return CaregiverDtoSet;
    }

    @Override
    public Set<Baby> getRequestedBabyList(String email) {
        Caregiver caregiver = caregiverDao.findCaregiverByUser(userDao.findByEmail(email));
        return caregiver.getRequestedBabies();
    }

    

    
}

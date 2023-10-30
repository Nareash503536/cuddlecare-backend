package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.BabyDao;
import com.example.CuddleCare.dao.CaregiverDao;
import com.example.CuddleCare.dao.UserDao;
import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Caregiver;
import com.example.CuddleCare.entity.Parents;
import com.example.CuddleCare.mapper.BabyMapper;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.CaregiverService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BabyServiceImpl implements BabyService {

    private BabyDao babyDao;
    private CaregiverDao caregiverDao;
    private BabyMapper babyMapper;
    private ParentServiceImpl parentService;
    private CaregiverService caregiverService;
    private UserDao userDao;

    public BabyServiceImpl(
            BabyDao babyDao,
            BabyMapper babyMapper,
            ParentServiceImpl parentService,
            CaregiverService caregiverService,
            CaregiverDao caregiverDao,
            UserDao userDao
            ) {
        this.babyDao = babyDao;
        this.parentService = parentService;
        this.babyMapper = babyMapper;
        this.caregiverService = caregiverService;
        this.caregiverDao = caregiverDao;
        this.userDao = userDao;
    }

    @Override
    public Baby loadBabyById(Long babyId) {
        // TODO Auto-generated method stub
        return babyDao.findByBabyID(babyId);
    }

    @Override
    public Baby updateBabyByAttribute(Long id, String attribute, String value) {
        Baby baby = loadBabyById(id);
        if(attribute.equals("babyname"))
            baby.setBabyName(value);
        else if(attribute.equals("dob"))
            baby.setDob(value);
        else if(attribute.equals("gender"))
            baby.setGender(value);
        return babyDao.save(baby);
    }

    @Override
    public Baby updateBaby(Baby baby) {
        // TODO Auto-generated method stub
        return babyDao.save(baby);
    }

    @Override
    public void addBabyToParent(BabyDTO babyDTO, ParentDTO parentDTO) {
        // TODO Auto-generated method stub
        Baby baby = loadBabyById(babyDTO.getBabyID());
        Parents parent = parentService.loadParentById(parentDTO.getParentID());
        baby.getParents().add(parent);
        parent.getBabies().add(baby);
    }

    @Override
    public BabyDTO createBaby(String BabyGender, String BabyDOB, String BabyName) {
        Baby savedBaby = babyDao.save(new Baby(BabyGender, BabyDOB, BabyName));
        return babyMapper.FromBaby(savedBaby);
    }

    @Override
    public void deleteBaby(Baby baby) {
        // TODO Auto-generated method stub
        babyDao.delete(baby);
    }

    @Override
    public Baby addBaby(Baby baby) {
        // TODO Auto-generated method stub
        return babyDao.save(baby);
    }

    @Override
    public Caregiver requestToCaregiveBaby(Long babyId, Long caregiverId) {
        Baby baby = loadBabyById(babyId);
        Caregiver caregiver  = caregiverService.loadCaregiverById(caregiverId);
        baby.addCaregiverRequest(caregiver);
        babyDao.save(baby);
        return caregiverDao.save(caregiver);
    }

    @Override
    public Caregiver acceptRequest(Long caregiverID, Long babyID) {
        Baby baby = loadBabyById(babyID);
        Caregiver caregiver = caregiverService.loadCaregiverById(caregiverID);
        caregiver.acceptCaregiverRequest(baby);
        babyDao.save(baby);
        return caregiverDao.save(caregiver);
    }

    @Override
    public Caregiver rejectRequest(Long babyId, Long caregiverId) {
        Baby baby = loadBabyById(babyId);
        Caregiver caregiver = caregiverService.loadCaregiverById(caregiverId);
        baby.removeCaregiverRequest(caregiver);
        babyDao.save(baby);
        return caregiverDao.save(caregiver);
    }

    @Override
    public List<Caregiver> getCaregiverRequestList(Long BabyID) {
        Baby baby = loadBabyById(BabyID);
        return caregiverDao.findAllByRequestedBabiesContaining(baby);
    }

    @Override
    public Baby removeCaregiver(Long babyId, Long caregiverId) {
        Baby baby = loadBabyById(babyId);
        Caregiver caregiver = caregiverService.loadCaregiverById(caregiverId);
        baby.removeCaregiver(caregiver);
        caregiverDao.save(caregiver);
        return babyDao.save(baby);
    }

    @Override
    public Baby acceptBabyRequest(Long babyID, String email) {
        Baby baby = loadBabyById(babyID);
        Caregiver caregiver = caregiverDao.findCaregiverByUser(userDao.findByEmail(email));
        baby.acceptRequest(caregiver);
        caregiverDao.save(caregiver);
        return babyDao.save(baby);
    }

    @Override
    public Baby cancelBabyRequest(Long BabyID, String email) {
        Baby baby = loadBabyById(BabyID);
        Caregiver caregiver = caregiverDao.findCaregiverByUser(userDao.findByEmail(email));
        baby.removeCaregiverRequest(caregiver);
        caregiverDao.save(caregiver);
        return babyDao.save(baby);
    }
}

package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.BabyDao;
import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Parents;
import com.example.CuddleCare.mapper.BabyMapper;
import com.example.CuddleCare.service.BabyService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BabyServiceImpl implements BabyService {

    private BabyDao babyDao;
    private BabyMapper babyMapper;
    private ParentServiceImpl parentService;

    public BabyServiceImpl(
            BabyDao babyDao,
            BabyMapper babyMapper,
            ParentServiceImpl parentService) {
        this.babyDao = babyDao;
        this.parentService = parentService;
        this.babyMapper = babyMapper;
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

}

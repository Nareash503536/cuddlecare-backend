package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Baby;

public interface BabyService {

    BabyDTO createBaby(String BabyGender, String BabyDOB, String BabyName);

    void addBabyToParent(BabyDTO babyDTO, ParentDTO parentDTO);

    Baby loadBabyById(Long babyId);
}

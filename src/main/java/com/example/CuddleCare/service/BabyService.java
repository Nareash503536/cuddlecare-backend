package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.ParentDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Caregiver;

import java.util.List;

public interface BabyService {
    BabyDTO createBaby(String BabyGender, String BabyDOB, String BabyName);
    void addBabyToParent(BabyDTO babyDTO, ParentDTO parentDTO);
    Baby loadBabyById(Long babyId);
    Baby updateBabyByAttribute(Long id, String attribute, String value);
    Baby updateBaby(Baby baby);
    void deleteBaby(Baby baby);
    Baby addBaby(Baby baby);
    Caregiver requestToCaregiveBaby(Long babyId, Long caregiverId);
    Caregiver acceptRequest(Long babyId, Long caregiverId);
    Caregiver rejectRequest(Long babyId, Long caregiverId);
    List<Caregiver> getCaregiverRequestList(Long BabyID);
    Baby removeCaregiver(Long babyId, Long caregiverId);
    Baby acceptBabyRequest(Long babyID, String email);
    Baby cancelBabyRequest(Long BabyID, String email);
}

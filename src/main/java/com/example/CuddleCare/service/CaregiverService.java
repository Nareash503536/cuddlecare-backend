package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.CaregiverDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Caregiver;

import java.util.List;
import java.util.Set;

public interface CaregiverService {
    CaregiverDTO createCaregiver(CaregiverDTO caregiverDTO);
    CaregiverDTO assignCaregiverRole(CaregiverDTO caregiverDTO);
    Caregiver loadCaregiverById(Long id);
    Set<Baby> loadBabiesByCaregiver(String email);
    Caregiver updateCaregiver(Caregiver caregiver);
    List<CaregiverDTO> getCaregiverList();
    Set<Baby> getRequestedBabyList(String email); 
}

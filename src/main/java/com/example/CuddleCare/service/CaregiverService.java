package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.CaregiverDTO;

public interface CaregiverService {
    
    CaregiverDTO createCaregiver(CaregiverDTO caregiverDTO);
    CaregiverDTO assignCaregiverRole(CaregiverDTO caregiverDTO);
//    List<BabyDTO> loadBabiesByCaregiver(User user);

}

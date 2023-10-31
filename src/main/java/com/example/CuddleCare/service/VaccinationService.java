package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.VaccinationDTO;
import com.example.CuddleCare.entity.Vaccination;

import java.util.Set;

public interface VaccinationService {
    Vaccination createVaccination(VaccinationDTO vaccinationDTO);
    Set<VaccinationDTO> getAllVaccinations();
    Set<VaccinationDTO> getVaccinationByBaby(Long babyID);
}

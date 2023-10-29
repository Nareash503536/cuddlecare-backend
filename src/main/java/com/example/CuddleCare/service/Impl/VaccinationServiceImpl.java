package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.VaccinationDao;
import com.example.CuddleCare.dto.VaccinationDTO;
import com.example.CuddleCare.entity.Vaccination;
import com.example.CuddleCare.mapper.VaccinationMapper;
import com.example.CuddleCare.service.VaccinationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class VaccinationServiceImpl implements VaccinationService {

    private VaccinationDao vaccinationDao;
    private VaccinationMapper vaccinationMapper;

    @Override
    public Vaccination createVaccination(VaccinationDTO vaccinationDTO) {
        Vaccination vaccination = vaccinationMapper.FromVaccinationDto(vaccinationDTO);
        vaccinationDao.save(vaccination);
        return vaccination;
    }

    @Override
    public Set<VaccinationDTO> getAllVaccinations() {
        return vaccinationDao.findAll().stream().map(
                vaccination -> vaccinationMapper.FromVaccination(vaccination)
        ).collect(Collectors.toSet());
    }
}

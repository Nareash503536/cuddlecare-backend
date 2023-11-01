package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.VaccinationDao;
import com.example.CuddleCare.dto.VaccinationDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Vaccination;
import com.example.CuddleCare.mapper.VaccinationMapper;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.VaccinationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class VaccinationServiceImpl implements VaccinationService {

    private VaccinationDao vaccinationDao;
    private VaccinationMapper vaccinationMapper;
    private BabyService babyService;

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

    @Override
    public Set<VaccinationDTO> getVaccinationByBaby(Long babyID) {
        Baby baby = babyService.loadBabyById(babyID);
        return baby.getVaccinations().stream().map(
                vaccination -> vaccinationMapper.FromVaccination(vaccination)
        ).collect(Collectors.toSet());
    }

    public int getAgeInMonths(String dob) {
        LocalDate date = LocalDate.parse(dob, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the period (difference) between the DOB and current date
        Period period = Period.between(date, currentDate);

        // Calculate the number of months
        return period.getYears() * 12 + period.getMonths();
    }

    @Override
    public Set<VaccinationDTO> getUpcomingVaccines(Long BabyID) {
        Baby baby = babyService.loadBabyById(BabyID);
        //compare baby age in months with vaccination months
        //print baby age in months
        System.out.println("Baby age in months: " + getAgeInMonths(baby.getDob()));
        return getAllVaccinations().stream().filter(
                vaccination -> getAgeInMonths(baby.getDob()) == vaccination.getMonths()
        ).collect(Collectors.toSet());
    }
}

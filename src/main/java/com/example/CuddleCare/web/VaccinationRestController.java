package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.VaccinationDTO;
import com.example.CuddleCare.service.VaccinationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
public class VaccinationRestController {
    private VaccinationService vaccinationService;

    @GetMapping("/getAllVaccines")
    public Set<VaccinationDTO> getAll() {
        return vaccinationService.getAllVaccinations();
    }

    @PostMapping("/getVaccineByBaby")
    public Set<VaccinationDTO> getVaccineByBaby(@RequestParam(name="babyID") Long babyID) {
        return vaccinationService.getVaccinationByBaby(babyID);
    }

    @GetMapping("/upcomingVaccines")
    public Set<VaccinationDTO> getUpcomingVaccines(@RequestParam(name = "babyID") Long babyID) {
        return vaccinationService.getUpcomingVaccines(babyID);
    }

}

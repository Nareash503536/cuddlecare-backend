package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.VaccinationDTO;
import com.example.CuddleCare.service.VaccinationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@CrossOrigin("/vaccination")
public class VaccinationRestController {
    private VaccinationService vaccinationService;

    @GetMapping("/getAll")
    public Set<VaccinationDTO> getAll() {
        return vaccinationService.getAllVaccinations();
    }

}

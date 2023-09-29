package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.DiaperDTO;
import com.example.CuddleCare.service.DiaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/diaper")
public class DiaperRestController {

    private final DiaperService diaperService;

    @Autowired
    public DiaperRestController(DiaperService diaperService) {
        this.diaperService = diaperService;
    }

    @PostMapping("/save")
    public ResponseEntity<DiaperDTO> saveDiaperChanges(@RequestBody DiaperDTO diaperDTO) {
        try {
            DiaperDTO saveDiaperData = diaperService.saveDiaperChanges(diaperDTO);
            return ResponseEntity.ok(saveDiaperData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving diaper changes");
        }
    }

    @GetMapping("/getAll/{currentDate}")
    public ResponseEntity<List<DiaperDTO>> getAllDiaperChanges(@PathVariable String currentDate) {
        try {
            LocalDate parsedDate = LocalDate.parse(currentDate);
            List<DiaperDTO> diaperChanges = diaperService.getAllDiaperChanges(parsedDate);
            return ResponseEntity.ok(diaperChanges);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting diaper changes");
        }
    }

    @GetMapping("/lastDiaperChange/{currentDate}")
    public ResponseEntity<DiaperDTO> getLastDiaperChangeByDate(@PathVariable String currentDate) {
        try {
            LocalDate parsedDate = LocalDate.parse(currentDate);
            DiaperDTO lastChange = diaperService.getLastDiaperChangeByDate(parsedDate);
            return ResponseEntity.ok(lastChange);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting last diaper change");
        }
    }
}

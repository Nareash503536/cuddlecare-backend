package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.SleepDTO;
import com.example.CuddleCare.dto.SleepViewDTO;
import com.example.CuddleCare.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/sleep")
public class SleepRestController {
    private final SleepService sleepService;

    @Autowired
    public SleepRestController(SleepService sleepService) {
        this.sleepService = sleepService;
    }

    @PostMapping("/save")
    public ResponseEntity<SleepDTO> saveSleep(@RequestBody SleepDTO sleepDTO) {
        try {
            SleepDTO saveSleepData = sleepService.saveSleep(sleepDTO);
            return ResponseEntity.ok(saveSleepData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving sleep");
        }
    }

    @GetMapping("/last-sleep/{currentDate}")
    public ResponseEntity<SleepDTO> getLastSleepByDate(@PathVariable String currentDate) {
        try {
            LocalDate parsedDate = LocalDate.parse(currentDate);
            SleepDTO lastSleep = sleepService.getLastSleepByDate(parsedDate);
            return ResponseEntity.ok(lastSleep);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting last sleep");
        }
    }

    @GetMapping("/all-sleeps/{currentDate}")
    public ResponseEntity<List<SleepDTO>> getAllSleepsByDate(@PathVariable String currentDate) {
        try {
            LocalDate parsedDate = LocalDate.parse(currentDate);
            List<SleepDTO> sleeps = sleepService.getAllSleepsByCurrentDate(parsedDate);
            return ResponseEntity.ok(sleeps);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting sleep data");
        }
    }

    @GetMapping("/total-sleep-duration/{currentDate}")
    public ResponseEntity<Time> getTotalSleepDurationByDate(@PathVariable String currentDate) {
        try {
            LocalDate parsedDate = LocalDate.parse(currentDate);
            Time totalSleepDuration = sleepService.getTotalSleepDurationByCurrentDate(parsedDate);
            return ResponseEntity.ok(totalSleepDuration);
        } catch (DateTimeParseException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/weeklySleepData")
    public ResponseEntity<List<SleepViewDTO>> getWeeklySleepData() {
        try {
            List<SleepViewDTO> weeklySleepData = sleepService.getWeeklySleepData();
            return ResponseEntity.ok(weeklySleepData);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while getting weekly sleep data");
        }
    }
}

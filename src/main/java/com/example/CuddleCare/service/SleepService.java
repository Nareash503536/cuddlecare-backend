package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.SleepDTO;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public interface SleepService {
    SleepDTO saveSleep(SleepDTO sleepDTO);

    SleepDTO getLastSleepByDate(LocalDate currentDate);

    List<SleepDTO> getAllSleepsByCurrentDate(LocalDate currentDate);

    Time getTotalSleepDurationByCurrentDate(LocalDate currentDate);
}

package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.DiaperDTO;
import com.example.CuddleCare.dto.DiaperViewDTO;

import java.time.LocalDate;
import java.util.List;

public interface DiaperService {

    DiaperDTO saveDiaperChanges(DiaperDTO diaperDTO);

    List<DiaperDTO> getAllDiaperChanges(LocalDate currentDate);

    DiaperDTO getLastDiaperChangeByDate(LocalDate parsedDate);

    List<DiaperViewDTO> getWeeklyDiaperCount();
}

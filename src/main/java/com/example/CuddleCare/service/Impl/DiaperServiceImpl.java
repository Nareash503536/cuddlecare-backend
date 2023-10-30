package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.DiaperDao;
import com.example.CuddleCare.dao.DiaperViewDao;
import com.example.CuddleCare.dto.DiaperDTO;
import com.example.CuddleCare.dto.DiaperViewDTO;
import com.example.CuddleCare.entity.Diaper;
import com.example.CuddleCare.mapper.DiaperMapper;
import com.example.CuddleCare.mapper.DiaperViewMapper;
import com.example.CuddleCare.service.DiaperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class DiaperServiceImpl implements DiaperService {

    private final DiaperDao diaperDao;
    private final DiaperViewDao diaperViewDao;
    private final DiaperMapper diaperMapper;
    private final DiaperViewMapper diaperViewMapper;
    @Override
    public DiaperDTO saveDiaperChanges(DiaperDTO diaperDTO) {
        try{
            Diaper entity = diaperMapper.toEntity(diaperDTO);
            Diaper savedEntity = diaperDao.save(entity);
            return diaperMapper.toDTO(savedEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving diaper change");
        }
    }

    @Override
    public List<DiaperDTO> getAllDiaperChanges(LocalDate currentDate) {
        Instant startOfToday = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant startOfTomorrow = currentDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        List<Diaper> diaperChanges = diaperDao.findByDateBetweenOrderByDateDesc(startOfToday, startOfTomorrow);
        if (diaperChanges.isEmpty()) {
            return null;
        }
        System.out.println(diaperChanges);
        return diaperMapper.toDTOList(diaperChanges);
    }

    @Override
    public DiaperDTO getLastDiaperChangeByDate(LocalDate currentDate) {
        Instant startOfToday = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant startOfTomorrow = currentDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        Diaper lastChange = diaperDao.findTopByDateBetweenOrderByTimeDesc(startOfToday, startOfTomorrow);

        if (lastChange == null) {
            return null;
        }

        return diaperMapper.toDTO(lastChange);
    }

    @Override
    public List<DiaperViewDTO> getWeeklyDiaperCount() {
        Instant now = Instant.now();
        Instant startOfWeek = now.atZone(ZoneId.systemDefault()).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toInstant();
        Instant endOfWeek = startOfWeek.plus(6, ChronoUnit.DAYS);

        List<Object[]> result = diaperViewDao.getWeeklyDiaperCount(startOfWeek,endOfWeek);
        List<DiaperViewDTO> diaperDTOS = new ArrayList<>();

        for (Object[] row : result){
            DiaperViewDTO dto = diaperViewMapper.toDTO(row);
            diaperDTOS.add(dto);
        }
        System.out.println(diaperDTOS);
        return diaperDTOS;
    }
}

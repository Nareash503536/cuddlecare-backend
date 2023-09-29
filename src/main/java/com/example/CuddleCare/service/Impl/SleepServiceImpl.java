package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.SleepDao;
import com.example.CuddleCare.dto.SleepDTO;
import com.example.CuddleCare.entity.Sleep;
import com.example.CuddleCare.mapper.SleepMapper;
import com.example.CuddleCare.service.SleepService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class SleepServiceImpl implements SleepService {

    private final SleepDao sleepDao;
    private final SleepMapper sleepMapper;

    @Override
    public SleepDTO saveSleep(SleepDTO sleepDTO) {
        try {
            //TODO: fill the gap of 5.30 hours before storing to db
            Sleep entity = sleepMapper.toEntity(sleepDTO);
            Sleep savedEntity = sleepDao.save(entity);
            return sleepMapper.toDTO(savedEntity);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while saving sleep");
        }
    }

    @Override
    public SleepDTO getLastSleepByDate(LocalDate currentDate) {
        Instant startOfToday = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant startOfTomorrow = currentDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        Sleep lastSleep = sleepDao.findTopBySleepStartTimeBetweenOrderBySleepStartTimeDesc(startOfToday, startOfTomorrow);

        if (lastSleep == null) {
            return null;
        }

        return sleepMapper.toDTO(lastSleep);
    }

    @Override
    public List<SleepDTO> getAllSleepsByCurrentDate(LocalDate currentDate) {
//        LocalDate currentDate = LocalDate.now();
        Instant startOfToday = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant startOfTomorrow = currentDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        List<Sleep> sleeps = sleepDao.findBySleepStartTimeBetweenOrderBySleepStartTimeDesc(startOfToday, startOfTomorrow);

        if (sleeps.isEmpty()) {
            return null;
        }

        return sleepMapper.toDTOs(sleeps);
    }

    @Override
    public Time getTotalSleepDurationByCurrentDate(LocalDate currentDate) {
//        LocalDate currentDate = LocalDate.now();
        Instant startOfToday = currentDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant startOfTomorrow = currentDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        List<Sleep> sleeps = sleepDao.findBySleepStartTimeBetween(startOfToday, startOfTomorrow);

        if (sleeps.isEmpty()) {
            return null;
        }

        long totalMilliseconds = sleeps.stream()
                .mapToLong(sleep -> sleep.getSleepDuration().toLocalTime().toNanoOfDay() / 1_000_000)
                .sum();

        Time totalSleepDuration = new Time(totalMilliseconds);
        return totalSleepDuration;
    }
}

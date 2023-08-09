package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface SleepDao extends JpaRepository<Sleep, Long> {

    Sleep findTopBySleepStartTimeLessThanEqualOrderBySleepStartTimeDesc(Instant startOfTomorrow);

    List<Sleep> findBySleepStartTimeBetweenOrderBySleepStartTimeDesc(Instant startOfToday, Instant startOfTomorrow);

    List<Sleep> findBySleepStartTimeBetween(Instant startOfToday, Instant startOfTomorrow);
}

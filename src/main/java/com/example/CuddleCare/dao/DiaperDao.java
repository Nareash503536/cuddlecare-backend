package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Diaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface DiaperDao extends JpaRepository<Diaper, Long> {

    List<Diaper> findByDateBetweenOrderByDateDesc(Instant startOfToday, Instant startOfTomorrow);

    Diaper findTopByDateBetweenOrderByTimeDesc(Instant startOfToday, Instant startOfTomorrow);
}

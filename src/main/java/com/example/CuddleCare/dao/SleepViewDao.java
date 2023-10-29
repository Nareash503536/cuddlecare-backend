package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface SleepViewDao extends JpaRepository<Sleep, Long>{
    @Query(nativeQuery = true, value = "SELECT CASE EXTRACT(DOW FROM sleep_start_time)\n" +
            "        WHEN 0 THEN 'Sun'\n" +
            "        WHEN 1 THEN 'Mon'\n" +
            "        WHEN 2 THEN 'Tue'\n" +
            "        WHEN 3 THEN 'Wed'\n" +
            "        WHEN 4 THEN 'Thu'\n" +
            "        WHEN 5 THEN 'Fri'\n" +
            "        WHEN 6 THEN 'Sat'\n" +
            "        ELSE 'Unknown'\n" +
            "    END as date, CAST(COALESCE(SUM(EXTRACT(EPOCH FROM sleep_duration)) / 60, 0) AS bigint) as sleepDuration " +
            "FROM sleep " +
            "WHERE sleep_start_time BETWEEN :startOfWeek AND :endOfWeek " +
            "GROUP BY EXTRACT(DOW FROM sleep_start_time) " +
            "ORDER BY EXTRACT(DOW FROM sleep_start_time)")
    List<Object[]> getWeeklySleepData(Instant startOfWeek, Instant endOfWeek);
}

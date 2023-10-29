package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Diaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Instant;
import java.util.List;

public interface DiaperViewDao extends JpaRepository<Diaper, Long> {
    @Query(nativeQuery = true, value = "SELECT CASE EXTRACT(DOW FROM date)\n" +
            "        WHEN 0 THEN 'Sun'\n" +
            "        WHEN 1 THEN 'Mon'\n" +
            "        WHEN 2 THEN 'Tue'\n" +
            "        WHEN 3 THEN 'Wed'\n" +
            "        WHEN 4 THEN 'Thu'\n" +
            "        WHEN 5 THEN 'Fri'\n" +
            "        WHEN 6 THEN 'Sat'\n" +
            "        ELSE 'Unknown'\n" +
            "    END as date, CAST(COUNT(*) AS bigint) as count " +
            "FROM diaper " +
            "WHERE date BETWEEN :startOfWeek AND :endOfWeek " +
            "GROUP BY EXTRACT(DOW FROM date) " +
            "ORDER BY EXTRACT(DOW FROM date)")
    List<Object[]> getWeeklyDiaperCount(Instant startOfWeek, Instant endOfWeek);
}

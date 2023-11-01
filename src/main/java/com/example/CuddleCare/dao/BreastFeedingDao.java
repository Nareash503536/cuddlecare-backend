package com.example.CuddleCare.dao;// new class BreastFeedingDao

import com.example.CuddleCare.entity.BottleFeeding;
import com.example.CuddleCare.entity.BreastFeeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BreastFeedingDao extends JpaRepository<BreastFeeding, Long> {
    @Query(value = "SELECT * FROM breastfeeding where feeding_day > ?1", nativeQuery = true)
    public List<BreastFeeding> AllFeedingsByDate(LocalDate threeDaysAgo);
}


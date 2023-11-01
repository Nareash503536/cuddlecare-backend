package com.example.CuddleCare.dao;// new class BreastFeedingDao

import com.example.CuddleCare.entity.BottleFeeding;
import com.example.CuddleCare.entity.BreastFeeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BottleFeedingDao extends JpaRepository<BottleFeeding, Long> {
    @Query(value = "SELECT * FROM bottlefeeding where feeding_date > ?1", nativeQuery = true)
    public List<BottleFeeding> AllFeedingsByDate(LocalDate threeDaysAgo);
}


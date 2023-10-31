package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.FoodFeeding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodFeedingDao extends JpaRepository<FoodFeeding, Long> {
}

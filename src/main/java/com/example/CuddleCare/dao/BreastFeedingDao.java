package com.example.CuddleCare.dao;// new class BreastFeedingDao

import com.example.CuddleCare.entity.BreastFeeding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreastFeedingDao extends JpaRepository<BreastFeeding, Long> {
}


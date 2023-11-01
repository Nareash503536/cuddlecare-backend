package com.example.CuddleCare.dao;// new class BabyDao

import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabyDao extends JpaRepository<Baby, Long> {
        Baby findByBabyName(String BabyName);
        Baby findByBabyID(Long babyId);
}



package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.SymptomBaby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomBabyDao extends JpaRepository<SymptomBaby, Long> {
    List<SymptomBaby> findAllByBabyAndDateOrderByDateAsc(Baby baby, String date);

    @Query("SELECT DISTINCT date FROM SymptomBaby WHERE baby.babyID = :babyID")
    List<String> findDistinctDatesByBaby(@Param("babyID") Long babyID);
}

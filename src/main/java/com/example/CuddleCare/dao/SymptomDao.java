package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomDao extends JpaRepository<Symptom, Long> {
    Symptom findByName(String name);
}

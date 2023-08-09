package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Caregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaregiverDao extends JpaRepository<Caregiver, Long> {
}

package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationDao extends JpaRepository<Vaccination, Long> {

}

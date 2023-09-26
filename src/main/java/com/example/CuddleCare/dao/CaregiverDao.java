package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Caregiver;
import com.example.CuddleCare.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaregiverDao extends JpaRepository<Caregiver, Long> {
    Caregiver findCaregiverByUser(User user);
    Caregiver findByCaregiverID(Long caregiverID);
    List<Caregiver> findAll();
    List<Caregiver> findAllByRequestedBabiesContaining(Baby baby);
}

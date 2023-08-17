package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderDao extends JpaRepository<Reminder,Long> {



}

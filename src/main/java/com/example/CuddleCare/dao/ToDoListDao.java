package com.example.CuddleCare.dao;

import com.example.CuddleCare.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ToDoListDao extends JpaRepository<ToDoList, Long> {
    List<ToDoList> findByDateOrderByTime(Instant date);

    List<ToDoList> findByDateAndStatusOrderByTime(Instant date, ToDoList.StatusTypes status);
}

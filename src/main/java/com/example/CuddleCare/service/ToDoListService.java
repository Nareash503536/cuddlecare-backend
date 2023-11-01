package com.example.CuddleCare.service;

import com.example.CuddleCare.dto.ToDoListDTO;

import java.time.Instant;
import java.util.List;

public interface ToDoListService {
    ToDoListDTO saveTask(ToDoListDTO toDoListDTO);

    List<ToDoListDTO> getToDoListForDate(Instant date);

    List<ToDoListDTO> getCompletedListForDate(Instant date);

    List<ToDoListDTO> getNonCompletedListForDate(Instant date);
}

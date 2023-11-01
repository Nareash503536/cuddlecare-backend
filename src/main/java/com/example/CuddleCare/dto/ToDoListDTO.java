package com.example.CuddleCare.dto;

import com.example.CuddleCare.entity.ToDoList;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.Instant;

@Getter
@Setter
@Builder
public class ToDoListDTO {
    private Long toDoID;
    private String task;
    private String taskDescription;
    private Instant date;
    private Time time;
    private ToDoList.StatusTypes status;
    private Long babyId;
    private Long caregiverId;
}

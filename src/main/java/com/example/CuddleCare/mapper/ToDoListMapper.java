package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.ToDoListDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Caregiver;
import com.example.CuddleCare.entity.ToDoList;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ToDoListMapper {
    public ToDoList toEntity(ToDoListDTO toDoListDTO) {
        ToDoList toDoList = new ToDoList();
        toDoList.setToDoID(toDoListDTO.getToDoID());
        toDoList.setTask(toDoListDTO.getTask());
        toDoList.setTaskDescription(toDoListDTO.getTaskDescription());
        toDoList.setDate(toDoListDTO.getDate());
        toDoList.setTime(toDoListDTO.getTime());
        toDoList.setStatus(toDoListDTO.getStatus());

        if (toDoListDTO.getBabyId() != null) {
            Baby baby = new Baby();
//            baby.setBabyID(toDoListDTO.getBabyId());
            toDoList.setBaby(baby);
        }

        if (toDoListDTO.getCaregiverId() != null) {
            Caregiver caregiver = new Caregiver();
//            caregiver.setCaregiverID(toDoListDTO.getCaregiverId());
            toDoList.setCaregiver(caregiver);
        }

        return toDoList;
    }

    public ToDoListDTO toDTO(ToDoList entity) {
        return ToDoListDTO.builder()
                .toDoID(entity.getToDoID())
                .task(entity.getTask())
                .taskDescription(entity.getTaskDescription())
                .date(entity.getDate())
                .time(entity.getTime())
                .status(entity.getStatus())
//                .babyId(entity.getBaby().getBabyID())
//                .caregiverId(entity.getCaregiver().getCaregiverID())
                .build();
    }

    public List<ToDoListDTO> toDTOs(List<ToDoList> toDoLists) {
        return toDoLists.stream()
                .map(this::toDTO)
                .collect(java.util.stream.Collectors.toList());
    }
}

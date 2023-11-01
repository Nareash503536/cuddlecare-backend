package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.ToDoListDTO;
import com.example.CuddleCare.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/todolist")
public class ToDoListRestController {

    private final ToDoListService toDoListService;

    @Autowired
    public ToDoListRestController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @PostMapping("/addTask")
    public ResponseEntity<ToDoListDTO> addTask(@RequestBody ToDoListDTO toDoListDTO){
        try {
            ToDoListDTO save = toDoListService.saveTask(toDoListDTO);
            return ResponseEntity.ok(save);
        }catch (Error e){
            e.printStackTrace();
            throw new RuntimeException("Error in adding task");
        }
    }

    @GetMapping("/getAll/{date}")
    public ResponseEntity<List<ToDoListDTO>> getToDoListForDate(@PathVariable Instant date){
        try {
            List<ToDoListDTO> toDoList = toDoListService.getToDoListForDate(date);
            return ResponseEntity.ok(toDoList);
        }catch (Error e){
            e.printStackTrace();
            throw new RuntimeException("Error in getting to do list");
        }
    }

    @GetMapping("/getAllCompleted/{date}")
    public ResponseEntity<List<ToDoListDTO>> getCompletedListForDate(@PathVariable Instant date){
        try {
            List<ToDoListDTO> toDoList = toDoListService.getCompletedListForDate(date);
            return ResponseEntity.ok(toDoList);
        }catch (Error e){
            e.printStackTrace();
            throw new RuntimeException("Error in getting to do list");
        }
    }

    @GetMapping("/getAllNotCompleted/{date}")
    public ResponseEntity<List<ToDoListDTO>> getNotCompletedListForDate(@PathVariable Instant date){
        try {
            List<ToDoListDTO> toDoList = toDoListService.getNonCompletedListForDate(date);
            return ResponseEntity.ok(toDoList);
        }catch (Error e){
            e.printStackTrace();
            throw new RuntimeException("Error in getting to do list");
        }
    }
}

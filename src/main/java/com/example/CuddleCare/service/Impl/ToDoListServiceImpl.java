package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.ToDoListDao;
import com.example.CuddleCare.dto.ToDoListDTO;
import com.example.CuddleCare.entity.ToDoList;
import com.example.CuddleCare.mapper.ToDoListMapper;
import com.example.CuddleCare.service.ToDoListService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class ToDoListServiceImpl implements ToDoListService {

    private ToDoListDao toDoListDao;
    private ToDoListMapper toDoListMapper;

    @Override
    public ToDoListDTO saveTask(ToDoListDTO toDoListDTO) {
        ToDoList toDoList = toDoListMapper.toEntity(toDoListDTO);
        ToDoList save = toDoListDao.save(toDoList);
        return toDoListMapper.toDTO(save);
    }

    @Override
    public List<ToDoListDTO> getToDoListForDate(Instant date) {
        List<ToDoList> lists = toDoListDao.findByDateOrderByTime(date);
        return toDoListMapper.toDTOs(lists);
    }

    @Override
    public List<ToDoListDTO> getCompletedListForDate(Instant date) {
        ToDoList.StatusTypes status = ToDoList.StatusTypes.valueOf("Completed");
        List<ToDoList> lists = toDoListDao.findByDateAndStatusOrderByTime(date, status);
        return toDoListMapper.toDTOs(lists);
    }

    @Override
    public List<ToDoListDTO> getNonCompletedListForDate(Instant date) {
        ToDoList.StatusTypes status = ToDoList.StatusTypes.valueOf("NotCompleted");
        List<ToDoList> lists = toDoListDao.findByDateAndStatusOrderByTime(date, status);
        return toDoListMapper.toDTOs(lists);
    }
}

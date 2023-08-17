package com.example.CuddleCare.mapper;

import com.example.CuddleCare.entity.Reminder;
import com.example.CuddleCare.dto.ReminderDTO;
import org.springframework.stereotype.Service;

@Service
public class ReminderMapper {

  public Reminder FromReminderDtoToReminder(ReminderDTO reminderDTO){
      Reminder reminder = new Reminder();
      reminder.setTitle(reminderDTO.getTitle());
      reminder.setDate(reminderDTO.getDate());
      reminder.setTime(reminderDTO.getTime());
      reminder.setReminderType(reminderDTO.getReminderType());
      reminder.setRingingFrequency(reminderDTO.getRingingFrequency());
      reminder.setRepeatFrequency(reminderDTO.getRepeatFrequency());
      return reminder;
  }

  public ReminderDTO FromReminderToReminderDto(Reminder reminder){
      ReminderDTO reminderDTO = new ReminderDTO();
      reminderDTO.setTitle(reminder.getTitle());
      reminderDTO.setDate(reminder.getDate());
      reminderDTO.setTime(reminder.getTime());
      reminderDTO.setReminderType(reminder.getReminderType());
        reminderDTO.setRingingFrequency(reminder.getRingingFrequency());
        reminderDTO.setRepeatFrequency(reminder.getRepeatFrequency());

      return reminderDTO;
  }




}

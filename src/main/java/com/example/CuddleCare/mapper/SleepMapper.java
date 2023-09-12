package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.SleepDTO;
import com.example.CuddleCare.entity.Baby;
import com.example.CuddleCare.entity.Sleep;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SleepMapper {
    public Sleep toEntity(SleepDTO sleepDTO) {
        Sleep sleep = new Sleep();
        sleep.setSleepID(sleepDTO.getSleepID());
        sleep.setSleepStartTime(sleepDTO.getSleepStartTime());
        sleep.setSleepEndTime(sleepDTO.getSleepEndTime());
        sleep.setSleepDuration(sleepDTO.getSleepDuration());
        sleep.setSleepType(sleepDTO.getSleepType());
        sleep.setSleepEnvironment(sleepDTO.getSleepEnvironment());
        sleep.setSleepQuality(sleepDTO.getSleepQuality());
        sleep.setSleepNotes(sleepDTO.getSleepNotes());

        if (sleepDTO.getBabyId() != null) {
            Baby baby = new Baby();
//            baby.setBabyId(sleepDTO.getBabyId());
            sleep.setBaby(baby);
        }

        return sleep;
    }

    public SleepDTO toDTO(Sleep sleep) {
        return SleepDTO.builder()
                .sleepID(sleep.getSleepID())
                .sleepStartTime(sleep.getSleepStartTime())
                .sleepEndTime(sleep.getSleepEndTime())
                .sleepDuration(sleep.getSleepDuration())
                .sleepType(sleep.getSleepType())
                .sleepEnvironment(sleep.getSleepEnvironment())
                .sleepQuality(sleep.getSleepQuality())
                .sleepNotes(sleep.getSleepNotes())
//                .babyId(sleep.getBaby().getBabyId())
                .build();
    }

    public List<SleepDTO> toDTOs(List<Sleep> sleeps) {
        return sleeps.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

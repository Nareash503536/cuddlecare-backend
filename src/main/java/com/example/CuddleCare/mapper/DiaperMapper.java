package com.example.CuddleCare.mapper;

import com.example.CuddleCare.dto.DiaperDTO;
import com.example.CuddleCare.entity.Diaper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiaperMapper {

    public Diaper toEntity(DiaperDTO diaperDTO) {
        Diaper diaper = new Diaper();
        diaper.setDiaperID(diaperDTO.getDiaperID());
        diaper.setDate(diaperDTO.getDate());
        diaper.setTime(diaperDTO.getTime());
        diaper.setDiaper_type(diaperDTO.getDiaper_type());
        diaper.setHumidity(diaperDTO.getHumidity());
        diaper.setStool_color(diaperDTO.getStool_color());
        diaper.setAdditionalNotes(diaperDTO.getAdditionalNotes());
        return diaper;
    }

    public DiaperDTO toDTO(Diaper diaper) {
        DiaperDTO diaperDTO = new DiaperDTO();
        diaperDTO.setDiaperID(diaper.getDiaperID());
        diaperDTO.setDate(diaper.getDate());
        diaperDTO.setTime(diaper.getTime());
        diaperDTO.setDiaper_type(diaper.getDiaper_type());
        diaperDTO.setHumidity(diaper.getHumidity());
        diaperDTO.setStool_color(diaper.getStool_color());
        diaperDTO.setAdditionalNotes(diaper.getAdditionalNotes());
        return diaperDTO;
    }

    public List<DiaperDTO> toDTOList(List<Diaper> diaperChanges) {
        return diaperChanges.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}

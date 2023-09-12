package com.example.CuddleCare.service.Impl;

import com.example.CuddleCare.dao.SymptomBabyDao;
import com.example.CuddleCare.dao.SymptomDao;
import com.example.CuddleCare.dto.SymptomBabyDTO;
import com.example.CuddleCare.dto.SymptomDTO;
import com.example.CuddleCare.entity.Symptom;
import com.example.CuddleCare.entity.SymptomBaby;
import com.example.CuddleCare.mapper.BabyMapper;
import com.example.CuddleCare.mapper.SymptomBabyMapper;
import com.example.CuddleCare.mapper.SymptomMapper;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.SymptomService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SymptomServiceImpl implements SymptomService{

    private SymptomDao symptomDao;
    private SymptomMapper symptomMapper;
    private BabyMapper babyMapper;
    private SymptomBabyDao symptomBabyDao;
    private SymptomBabyMapper symptomBabyMapper;
    private BabyService babyService;

    public SymptomServiceImpl(
            SymptomDao symptomDao,
            SymptomMapper symptomMapper,
            BabyMapper babyMapper,
            SymptomBabyDao symptomBabyDao,
            SymptomBabyMapper symptomBabyMapper,
            BabyService babyService
    ) {
        this.symptomDao = symptomDao;
        this.symptomMapper = symptomMapper;
        this.babyMapper = babyMapper;
        this.symptomBabyDao = symptomBabyDao;
        this.symptomBabyMapper = symptomBabyMapper;
        this.babyService = babyService;
    }

    @Override
    public Symptom createSymptom(String name) {
        Symptom symptom = new Symptom(name);
        symptomDao.save(symptom);
        return symptom;
    }

    @Override
    public SymptomBaby loadSymptomBabyByID(Long id) {
        return symptomBabyDao.findById(id).orElseThrow(() -> new EntityNotFoundException("SymptomBaby with ID" + id + " not found"));
    }

    @Override
    public SymptomBabyDTO createSymptomBaby(SymptomBabyDTO symptomBabyDTO) {
        SymptomBaby symptomBaby = new SymptomBaby();
        symptomBaby.setDate(symptomBabyDTO.getDate());
        symptomBaby.setTime(symptomBabyDTO.getTime());
        symptomBaby.setAdditionalNotes(symptomBabyDTO.getAdditionalNotes());
        symptomBaby.setSymptom(symptomMapper.FromSymptomDto(symptomBabyDTO.getSymptom()));
        symptomBaby.setBaby(babyMapper.FromBabyDto(symptomBabyDTO.getBaby()));
        SymptomBaby savedSymptomBaby = symptomBabyDao.save(symptomBaby);
        return symptomBabyMapper.FromSymptomBaby(savedSymptomBaby);
    }

    @Override
    public SymptomBabyDTO updateSymptomBaby(SymptomBabyDTO symptomBabyDTO) {
        SymptomBaby loadedSymptomBaby = loadSymptomBabyByID(symptomBabyDTO.getSymptomBabyID());
        if(loadedSymptomBaby == null){
            return null;
        }
        SymptomBaby symptomBaby = symptomBabyMapper.FromSymptomBabyDto(symptomBabyDTO);
        symptomBaby.setSymptomBabyID(loadedSymptomBaby.getSymptomBabyID());
        SymptomBaby savedSymptomBaby = symptomBabyDao.save(symptomBaby);
        return symptomBabyMapper.FromSymptomBaby(savedSymptomBaby);
    }

    @Override
    public void removeSymptomBaby(Long id) {
        symptomBabyDao.deleteById(id);
    }

    @Override
    public SymptomDTO loadSymptomByName(String name) {
        return symptomMapper.FromSymptom(symptomDao.findByName(name));
    }

    @Override
    public List<SymptomBabyDTO> loadSymptomBabyByDate(String date, Long babyID) {
        //get the list and convert into DTO list
        List<SymptomBabyDTO> symptomBabyDTOList = symptomBabyDao.findAllByBabyAndDateOrderByDateAsc(babyService.loadBabyById(babyID), date).stream().map(symptomBaby -> symptomBabyMapper.FromSymptomBaby(symptomBaby)).toList();
        return symptomBabyDTOList;
    }

    @Override
    public boolean ifSymptomBabyExistsOnDate(String date, Long babyID) {
        return symptomBabyDao.findAllByBabyAndDateOrderByDateAsc(babyService.loadBabyById(babyID), date).size() > 0;
    }

    @Override
    public List<String> loadDistinctDatesByBaby(Long babyID) {
        return symptomBabyDao.findDistinctDatesByBaby(babyID);
    }
}

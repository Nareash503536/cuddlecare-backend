package com.example.CuddleCare.web;

import com.example.CuddleCare.dto.BabyDTO;
import com.example.CuddleCare.dto.SymptomBabyDTO;
import com.example.CuddleCare.dto.SymptomDTO;
import com.example.CuddleCare.exceptions.UserException;
import com.example.CuddleCare.mapper.BabyMapper;
import com.example.CuddleCare.mapper.SymptomMapper;
import com.example.CuddleCare.service.BabyService;
import com.example.CuddleCare.service.SymptomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SymptomRestController {

    private SymptomService symptomService;
    private SymptomMapper symptomMapper;
    private BabyService babyService;
    private BabyMapper babyMapper;

    public SymptomRestController(
            SymptomService symptomService,
            SymptomMapper symptomMapper,
            BabyService babyService,
            BabyMapper babyMapper
    ) {
        this.symptomService = symptomService;
        this.symptomMapper = symptomMapper;
        this.babyService = babyService;
        this.babyMapper = babyMapper;
    }

    private SymptomBabyDTO createSymptomBaby(
            String date,
            String time,
            String additionalNotes,
            String symptomName,
            Long babyID
    ) {
        SymptomBabyDTO symptomBabyDTO = new SymptomBabyDTO();
        SymptomDTO symptomDTO = symptomService.loadSymptomByName(symptomName);
        BabyDTO babyDTO = babyMapper.FromBaby(babyService.loadBabyById(babyID));
        if(symptomDTO == null || babyDTO == null)
            return null;
        symptomBabyDTO.setDate(date);
        symptomBabyDTO.setTime(time);
        symptomBabyDTO.setAdditionalNotes(additionalNotes);
        symptomBabyDTO.setSymptom(symptomDTO);
        symptomBabyDTO.setBaby(babyDTO);
        return symptomBabyDTO;
    }

    @PostMapping("symptom/createSymptomForBaby")
    public ResponseEntity<UserException> createSymptomForBaby(
            @RequestParam("date") String date,
            @RequestParam("time") String time,
            @RequestParam("additionalNotes") String additionalNotes,
            @RequestParam("symptomName") String symptomName,
            @RequestParam("babyID") Long babyID
    ){
        UserException exception = new UserException();
        SymptomBabyDTO symptomBabyDTO = createSymptomBaby(
                date,
                time,
                additionalNotes,
                symptomName,
                babyID
        );
//        SymptomBabyDTO savedSymptomBabyDTO;
        if(symptomBabyDTO == null){
            exception.setError(true);
            exception.setResult("Symptom or Baby not found");
//            return null;
        } else{
            symptomService.createSymptomBaby(symptomBabyDTO);
            exception.setError(false);
            exception.setResult("Symptom updated");
//            return savedSymptomBabyDTO;
        }
        return ResponseEntity.ok(exception);
    }

    @PostMapping("symptom/updateSymptomForBaby")
    public ResponseEntity<UserException> updateSymptomForBaby(
            @RequestParam("date") String date,
            @RequestParam("time") String time,
            @RequestParam("additionalNotes") String additionalNotes,
            @RequestParam("symptomName") String symptomName,
            @RequestParam("babyID") Long babyID,
            @RequestParam("symptomBabyID") Long symptomBabyID
    ){
        UserException exception = new UserException();
        SymptomBabyDTO savedSymptomBabyDTO;
        SymptomBabyDTO symptomBabyDTO = createSymptomBaby(
                date,
                time,
                additionalNotes,
                symptomName,
                babyID
        );
        if(symptomBabyDTO == null){
            exception.setError(true);
            exception.setResult("Symptom or Baby not found");
        } else{
            symptomBabyDTO.setSymptomBabyID(symptomBabyID);
            savedSymptomBabyDTO = symptomService.updateSymptomBaby(symptomBabyDTO);
            if(savedSymptomBabyDTO == null){
                exception.setError(true);
                exception.setResult("Symptom for the particular baby is not found");
            } else {
                exception.setError(false);
                exception.setResult("Symptom updated");
            }
        }
        return ResponseEntity.ok(exception);
    }

    @DeleteMapping("symptom/removeSymptomForBaby")
    public ResponseEntity<UserException> removeSymptomForBaby(
            @RequestParam("id") Long id
    ){
        UserException exception = new UserException();
        if(symptomService.loadSymptomBabyByID(id) == null){
            exception.setError(true);
            exception.setResult("Symptom for the particular baby is not found");
        } else {
            symptomService.removeSymptomBaby(id);
            exception.setError(false);
            exception.setResult("Symptom for the particular baby is removed");
        }
        return ResponseEntity.ok(exception);
    }

    @GetMapping("symptom/getSymptomForBabyByDate")
    public List<SymptomBabyDTO> getSymptomForBabyByDate(
            @RequestParam("date") String date,
            @RequestParam("babyID") Long babyID
    ){
        return symptomService.loadSymptomBabyByDate(date, babyID);
    }

    @GetMapping("symptom/ifSymptomForBabyExistsOnDate")
    public boolean ifSymptomForBabyExistsOnDate(
            @RequestParam("date") String date,
            @RequestParam("babyID") Long babyID
    ){
        return symptomService.ifSymptomBabyExistsOnDate(date, babyID);
    }

    @GetMapping("symptom/getDatesForSymptomByBaby")
    public List<String> getDatesForSymptomByBaby(
            @RequestParam("babyID") Long babyID
    ){
        return symptomService.loadDistinctDatesByBaby(babyID);
    }
}

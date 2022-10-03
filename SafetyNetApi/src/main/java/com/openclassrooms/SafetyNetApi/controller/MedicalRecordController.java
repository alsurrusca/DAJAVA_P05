package com.openclassrooms.SafetyNetApi.controller;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    /**
     * Read - Get all Medical Reocrd
     *
     * @Return - A List object of Person
     */

    @GetMapping("/medicalRecord")
    public List<MedicalRecord> getMedicalRecord() {
        List<MedicalRecord> listOfMedicalRecord = medicalRecordService.getMedicalRecord();
        return listOfMedicalRecord;
    }


    /**
     * Create - Add a new medical Records
     *
     * @param medicalRecord - A object person
     * @return - The person object save
     */

    @PostMapping("/medicalRecord")
    public boolean createMedicalRecord (@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.saveMedicalRecords(medicalRecord);
    }


    @PutMapping("/medicalRecord")
    public boolean updateMedicalRecord(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthdate, @RequestParam List<String> medications,@RequestParam List<String> allergies) {
        boolean updateMedicalRecord = medicalRecordService.updateMedicalRecord(firstName, lastName, birthdate, medications, allergies);
        return updateMedicalRecord;
    }


    @DeleteMapping("/medicalRecord")
    public boolean deleteMedicalRecord(@RequestParam String birthdate, String medications, String allergies) {
       boolean deleteMedicalRecord = medicalRecordService.deleteMedicalRecords(birthdate, medications, allergies);
        return deleteMedicalRecord;
    }


}

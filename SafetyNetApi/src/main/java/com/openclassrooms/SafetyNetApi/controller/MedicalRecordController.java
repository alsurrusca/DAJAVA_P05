package com.openclassrooms.SafetyNetApi.controller;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public MedicalRecord createMedicalRecord (@RequestBody MedicalRecord medicalRecord) {
        return medicalRecordService.saveMedicalRecords(medicalRecord);
    }


    @PutMapping("/medicalRecord")
    public MedicalRecord updateMedicalRecord(@RequestParam List<String> medications, List<String> allergies) {
        MedicalRecord updateMedicalRecord = medicalRecordService.updateMedicalRecord(medications, allergies);
        return updateMedicalRecord;
    }


    @DeleteMapping("/medicalRecord")
    public void deleteMedicalRecord(@RequestParam String birthdate, String medications, String allergies) {
        medicalRecordService.deleteMedicalRecords(birthdate, medications, allergies);
    }


}

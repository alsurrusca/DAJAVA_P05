package com.openclassrooms.SafetyNetApi.controller;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.service.MedicalRecordService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;
    Logger log = LoggerFactory.getLogger(MedicalRecordController.class);


    /**
     * Read - Get all Medical Reocrd
     *
     * @Return - A List object of Person
     */

    @GetMapping("/medicalRecord")
    public List<MedicalRecord> getMedicalRecord() {
        List<MedicalRecord> listOfMedicalRecord = medicalRecordService.getMedicalRecord();
        if(listOfMedicalRecord.isEmpty()){
            log.error("Find All medicalRecords request FAILED");
        } else {
            log.info("Find all medicalRecord request SUCCESS");
        }
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
        log.info("Post MedicalRecord request SUCCESS");
        return medicalRecordService.saveMedicalRecords(medicalRecord);
    }


    @PutMapping("/medicalRecord")
    public boolean updateMedicalRecord(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String birthdate, @RequestParam List<String> medications,@RequestParam List<String> allergies) {
        boolean updateMedicalRecord = medicalRecordService.updateMedicalRecord(firstName, lastName, birthdate, medications, allergies);
        if(updateMedicalRecord){
            log.info("Update  medicalRecords request SUCCESS");
        } else {
            log.error("Update medicalRecord request FAILED");
        }
        return updateMedicalRecord;
    }


    @DeleteMapping("/medicalRecord")
    public boolean deleteMedicalRecord(@RequestParam String birthdate, String medications, String allergies) {
       boolean deleteMedicalRecord = medicalRecordService.deleteMedicalRecords(birthdate, medications, allergies);
        if(deleteMedicalRecord){
            log.info("Delete medicalRecords request SUCCESS");
        } else {
            log.info("Delete medicalRecord request FAILED");
        }
       return deleteMedicalRecord;
    }


}

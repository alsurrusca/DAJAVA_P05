package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordServiceImpl medicalRecordService = new MedicalRecordServiceImpl();


        public List<MedicalRecord> getMedicalRecord() {

            return medicalRecordService.findAll();
        }


        public boolean updateMedicalRecord(
                String firstName,
                String lastName,
                String birthdate,
                List<String> medications,
                List<String> allergies) {

            boolean updateMedicalRecord = medicalRecordService.updateMedicalRecords(firstName, lastName, birthdate, medications, allergies);
            return updateMedicalRecord;
        }


        public boolean saveMedicalRecords(MedicalRecord medicalRecord) {
            return medicalRecordService.addMedicalrecords(medicalRecord);
        }


        public boolean deleteMedicalRecords(String birthdate, String firstName, String lastName) {
            return medicalRecordService.deleteMedicalRecords(birthdate, firstName, lastName);
        }



}

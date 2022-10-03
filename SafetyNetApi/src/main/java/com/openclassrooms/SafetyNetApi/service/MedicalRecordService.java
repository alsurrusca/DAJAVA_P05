package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.repository.MedicalRecordImpl;
import com.openclassrooms.SafetyNetApi.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordImpl medicalRecordRepository = new MedicalRecordImpl();


        public List<MedicalRecord> getMedicalRecord() {

            return medicalRecordRepository.findAll();
        }


        public boolean updateMedicalRecord(
                String firstName,
                String lastName,
                String birthdate,
                List<String> medications,
                List<String> allergies) {

            boolean updateMedicalRecord = medicalRecordRepository.updateMedicalRecords(firstName, lastName, birthdate, medications, allergies);
            return updateMedicalRecord;
        }


        public boolean saveMedicalRecords(MedicalRecord medicalRecord) {
            return medicalRecordRepository.addMedicalrecords(medicalRecord);
        }


        public boolean deleteMedicalRecords(String birthdate, String firstName, String lastName) {
            return medicalRecordRepository.deleteMedicalRecords(birthdate, firstName, lastName);
        }



}

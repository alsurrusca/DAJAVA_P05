package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public List<MedicalRecord> getMedicalRecord(){
        return medicalRecordRepository.findAll();
    }

    public List<MedicalRecord> getMedicalRecords(){
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord updateMedicalRecord(
            List<String>medications,
            List<String> allergies) {

        MedicalRecord updateMedicalRecord = medicalRecordRepository.updateMedicalRecords(medications, allergies);
        return updateMedicalRecord;
    }

    public MedicalRecord saveMedicalRecords (MedicalRecord medicalRecord){
        return medicalRecordRepository.addMedicalrecords(medicalRecord);
    }

    public MedicalRecord deleteMedicalRecords (String birthdate, String firstName, String lastName) {
        return medicalRecordRepository.deleteMedicalRecords(birthdate, firstName, lastName);
    }


}

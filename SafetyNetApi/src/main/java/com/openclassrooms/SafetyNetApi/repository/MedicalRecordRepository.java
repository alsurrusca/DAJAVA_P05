package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository {


    List<MedicalRecord> findAll();

    MedicalRecord addMedicalrecords(MedicalRecord medicalRecord);

    MedicalRecord deleteMedicalRecords(String firstName, String lastName, String birthdate);

    MedicalRecord updateMedicalRecords(List<String> medications, List<String> allergies);


}

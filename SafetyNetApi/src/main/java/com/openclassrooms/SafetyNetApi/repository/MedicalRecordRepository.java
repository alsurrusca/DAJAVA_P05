package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository {


    List<MedicalRecord> findAll();

    boolean addMedicalrecords(MedicalRecord medicalRecord);

    boolean deleteMedicalRecords(String firstName, String lastName, String birthdate);

    boolean updateMedicalRecords(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies);


}

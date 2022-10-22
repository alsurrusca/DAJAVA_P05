package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalRecordImpl implements MedicalRecordRepository {

    @Override
    public List<MedicalRecord> findAll() {
        return Data.getMedicalRecords();
    }

    @Override
    public boolean addMedicalrecords(MedicalRecord medicalRecord) {
        MedicalRecord medicalToSave = null;
        if (medicalToSave == null) {
            Data.getMedicalRecords().add(medicalToSave);
        }

        return true;
    }

    @Override
    public boolean deleteMedicalRecords(String firstName, String lastName, String birthdate) {
        MedicalRecord medicalToDelete = null;
        for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName) && medicalRecord.getBirthdate().equals(birthdate)) {
                medicalToDelete = medicalRecord;
            }
        }

        if (medicalToDelete != null) {
            Data.getMedicalRecords().remove(medicalToDelete);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMedicalRecords(String firstName, String lastName, String birthdate, List<String> medications, List<String> allergies) {

        MedicalRecord medicalRecordToUpdate = new MedicalRecord();
        for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
            if (medicalRecord.getFirstName().equals(medicalRecord.getFirstName()) && medicalRecord.getLastName().equals(medicalRecord.getLastName())) {
                medicalRecordToUpdate.getAllergies();
                medicalRecordToUpdate.getMedications();
                return true;
            }


        }


        return false;
    }


    public MedicalRecord getByFirstName(String firstName) {
        for (MedicalRecord medicalRecord : Data.getMedicalRecords()){
            if(medicalRecord.getFirstName().equals(firstName)){
                return medicalRecord;
            }
        }
        return null;
    }


}

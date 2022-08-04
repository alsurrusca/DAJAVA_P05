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
    public MedicalRecord addMedicalrecords(MedicalRecord medicalRecord) {
        MedicalRecord medicalToSave = null;
        if (medicalToSave == null) {
            Data.getMedicalRecords().add(medicalToSave);
        }

        return medicalToSave;
    }

    @Override
    public MedicalRecord deleteMedicalRecords(String firstName, String lastName, String birthdate) {
        MedicalRecord medicalToDelete = null;
        for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
            if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
                medicalToDelete = medicalRecord;
            }
        }

        if (medicalToDelete != null) {
            Data.getMedicalRecords().remove(medicalToDelete);
            return null;
        }
        return null;
    }

    @Override
    public MedicalRecord updateMedicalRecords(List<String> medications, List<String> allergies) {

        MedicalRecord medicalRecordToUpdate = null;
        for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
            if (medicalRecord.getFirstName().equals(medicalRecord.getFirstName()) && medicalRecord.getLastName().equals(medicalRecord.getLastName())) {
                medicalRecordToUpdate.getAllergies();
                medicalRecordToUpdate.getMedications();
            }


        }


        return medicalRecordToUpdate;
    }

}

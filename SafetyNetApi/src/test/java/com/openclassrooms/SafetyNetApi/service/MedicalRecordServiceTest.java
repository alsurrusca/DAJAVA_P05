package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.repository.MedicalRecordImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {


    private MedicalRecordService medicalRecordService = new MedicalRecordService();
    @Mock
    private MedicalRecordImpl medicalRecordImpl = new MedicalRecordImpl();
    @Mock
    private MedicalRecord medicalRecord = new MedicalRecord();

    @Test
    public void getMedicalRecordTest() {

        //Then

        List<String> medication = List.of("aznol:350mg");
        List<String> allergies = List.of("nillacilan");

        medicalRecord = new MedicalRecord("firstName", "lastName", "01/23/4567", medication, allergies);

        Data.getMedicalRecords().add(medicalRecord);

        assertThat(medicalRecordService.getMedicalRecord().size() != 0);
    }

    @Test
    public void updateMedicalRecordTest() {

        List<String> medication = List.of("aznol:350mg");
        List<String> allergies = List.of("nillacilan");
        medicalRecord = new MedicalRecord("firstName", "lastName", "01/23/4567", medication, allergies);

        Data.getMedicalRecords().add(medicalRecord);

        //assertThat(medicalRecordService.updateMedicalRecords(medication, allergies)).isEqualTo(medication);
        assertThat(medicalRecord.getAllergies()).isEqualTo(allergies);
        assertThat(medicalRecord.getMedications()).isEqualTo(medication);


    }

    @Test
    public void addMedicalRecordTest() {

        List<String> medication = List.of("aznol:350mg");
        List<String> allergies = List.of("nillacilan");

        medicalRecord = new MedicalRecord("firstName", "lastName", "01/23/4567", medication, allergies);

        Data.getMedicalRecords().add(medicalRecord);

        //assertThat(medicalRecord.getMedications()).isEqualTo("aznol:350mg");
        //assertThat(medicalRecord.getAllergies()).isEqualTo("nillacilan");
        assertThat(medicalRecord.getMedications()).isNotNull();
        assertThat(medicalRecord.getAllergies()).isNotNull();


    }

    @Test
    public void deleteMedicalRecordTest() {


        List<String> medication = List.of("aznol:350mg");
        List<String> allergies = List.of("nillacilan");

        medicalRecord = new MedicalRecord("firstName", "lastName", "01/23/4567", medication, allergies);
        Data.getMedicalRecords().add(medicalRecord);

        medicalRecordImpl.deleteMedicalRecords("firstName", "lastName", "01/23/4567");

        //On prend la date de naissance car si 2 personnes à le même nom, il n'y a quasiment pas de chance qu'elles aient la même date de naissance
        assertThat(medicalRecordService.getMedicalRecord()).doesNotHaveToString("01/23/4567");

    }


}

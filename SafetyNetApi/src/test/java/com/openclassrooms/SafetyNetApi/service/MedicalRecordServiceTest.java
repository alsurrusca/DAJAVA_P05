package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.repository.MedicalRecordImpl;
import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@WebMvcTest(MedicalRecordService.class)
@AutoConfigureMockMvc
public class MedicalRecordServiceTest {



    @Autowired
    private MedicalRecordService medicalRecordService;

    @MockBean
    private MedicalRecordImpl medicalRecordImpl;

    @MockBean
    private MedicalRecord medicalRecord;

    @Test
    //OK
    public void getMedicalRecordTest() {

        medicalRecordService = new MedicalRecordService();

        medicalRecordImpl = new MedicalRecordImpl();
        //Then

        List<String> medication = List.of("aznol:350mg");
        List<String> allergies = List.of("nillacilan");
        medicalRecord = new MedicalRecord("FistName", "LastName", "01/01/2001", medication, allergies);
       medicalRecordImpl.findAll();


        assertThat(medicalRecordService.getMedicalRecord().size() != 0);
    }

    @Test
    public void updateMedicalRecordTest() {

        medicalRecordService = new MedicalRecordService();
        medicalRecordImpl = new MedicalRecordImpl();


        List<String> medication = List.of("aznol:350mg");
        List<String> allergies = List.of("nillacilan");
        medicalRecord = new MedicalRecord("firstName", "lastName", "01/23/4567", medication, allergies);

        Data.getMedicalRecords().add(medicalRecord);

        List<String> medication1 = List.of("doliprane");
        List<String> allergies1 = List.of("doliprane");
        medicalRecord = new MedicalRecord("firstName", "lastName", "01/23/4567", medication1, allergies1);

        assertTrue(medicalRecordService.updateMedicalRecord(medication1,allergies1));




    }

    @Test
    public void addMedicalRecordTest() {

       medicalRecordImpl = new MedicalRecordImpl();
       medicalRecordService = new MedicalRecordService();
       medicalRecord = new MedicalRecord();

        List<String> medication = List.of(("aznol:350mg"));
       List<String> allergies;

       allergies = List.of("nillacilan");

       medicalRecord.setMedications(medication);
       medicalRecord.setAllergies(allergies);

        medicalRecord = new MedicalRecord("firstName", "lastName", "01/23/4567", medication, allergies);


        assertTrue(medicalRecordService.saveMedicalRecords(medicalRecord));
       assertThat(medicalRecord.getBirthdate()).isEqualTo("01/23/4567");


    }

    @Test
    public void deleteMedicalRecordTest() {

        medicalRecordImpl = new MedicalRecordImpl();
        medicalRecordService = new MedicalRecordService();



        List<String> medication = List.of("aznol:350mg");
        List<String> allergies = List.of("nillacilan");

        medicalRecord = new MedicalRecord("firstName", "lastName", "01/23/4567", medication, allergies);
        Data.getMedicalRecords().add(medicalRecord);

        medicalRecordImpl.deleteMedicalRecords("firstName", "lastName", "01/23/4567");

        assertThat(medicalRecordService.deleteMedicalRecords("01/23/4567", "firstName", "lastName")).doesNotHaveToString("01/23/4567");

    }



}

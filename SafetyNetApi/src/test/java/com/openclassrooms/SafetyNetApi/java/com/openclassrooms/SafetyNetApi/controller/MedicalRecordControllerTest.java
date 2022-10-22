package com.openclassrooms.SafetyNetApi.controller;



import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.service.MedicalRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)


public class MedicalRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MedicalRecordService medicalRecordService;

    @Test
    public void getMedicalRecordTest() throws Exception {

               mockMvc.perform(get("/medicalRecord"))
                .andExpect(status().isOk());

    }


    @Test
    public void createMedicalRecord() throws Exception {

        List<String> medications = List.of("medications");
        List<String> allergies = List.of("allergies");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname","Lastname", "01/01/2000", medications, allergies);
        when(medicalRecordService.saveMedicalRecords(medicalRecord)).thenReturn(true);
        mockMvc.perform(get("/medicalRecord?firstName=Firstname&lastName=Lastname&birthdate=01/01/2000&medications=medications&allergies=allergies"))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteMedicalRecordTest() throws Exception {
        List<String> medications = List.of("medications");
        List<String> allergies = List.of("allergies");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname","Lastname", "01/01/2000", medications, allergies);
        when(medicalRecordService.deleteMedicalRecords("01/01/2000","Firstname","Lastname")).thenReturn(true);
        mockMvc.perform(delete("/medicalRecord?birthdate=01/01/2000&firstName=Firstname&lastName=Lastname"))
                .andExpect(status().isOk());

    }

    @Test
    public void updateMedicalRecordTest() throws Exception {
        List<String> medications = List.of("medications");
        List<String> allergies = List.of("allergies");
        MedicalRecord medicalRecord = new MedicalRecord("Firstname","Lastname", "01/01/2000", medications, allergies);

        when(medicalRecordService.saveMedicalRecords(medicalRecord)).thenReturn(true);

        List<String> medications1 = List.of("medications1");
        List<String> allergies1 = List.of("allergies1");

        mockMvc.perform(put("/medicalRecord?firstName=name&lastName=name&birthdate=03/10/2022&medications=medications1&allergies=allergies1"))
                .andExpect(status().isOk());

        verify(medicalRecordService,times(1)).updateMedicalRecord("name","name","03/10/2022",medications1,allergies1);

    }
}

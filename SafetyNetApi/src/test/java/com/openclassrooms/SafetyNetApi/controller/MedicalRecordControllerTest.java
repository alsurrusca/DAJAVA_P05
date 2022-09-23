package com.openclassrooms.SafetyNetApi.controller;

import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.repository.MedicalRecordImpl;
import com.openclassrooms.SafetyNetApi.service.MedicalRecordService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
/**
//@AutoConfigureMockMvc
@WebMvcTest(MedicalRecordController.class)
@ExtendWith(MockitoExtension.class)


public class MedicalRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private MedicalRecordController medicalRecordController = new MedicalRecordController();

    @MockBean
    private MedicalRecordImpl medicalRecordImpl = new MedicalRecordImpl();

    @MockBean
    private MedicalRecord medicalRecord;

   /** @BeforeEach
    public void setUp(){

       // mockMvc = MockMvcBuilders.standaloneSetup(medicalRecordController).build();
    }

    @Test
    public void getMedicalRecordTest() throws Exception {

        List<String> medication = List.of("aznol:350mg");
        List<String> allergies = List.of("nillacilan");
        medicalRecord = new MedicalRecord("FistName", "LastName", "01/01/2001", medication, allergies);

        //Mockito.when(medicalRecordImpl.findAll()).thenReturn((List<MedicalRecord>) medicalRecord);
        mockMvc.perform(get("/medicalRecord"))
                .andExpect(status().isOk());

    }



   @Autowired
   private MedicalRecordService medicalRecordService;

    @Test
    public void getMedicalRecordsTest_shouldReturnOk() throws Exception {
        medicalRecordService = new MedicalRecordService();

        when(medicalRecordService.getMedicalRecord()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/medicalrecords"))
                .andExpect(status().isOk());
    }
}
**/
package com.openclassrooms.SafetyNetApi.controller;


import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.service.FireStationService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FireStationService fireStationService;

    @Test
    public void getFirestationTest() throws Exception {

        mockMvc.perform(get("/firestations")).andExpect((status().isOk()));

    }
/**
    @Test
    public void createFirestationTest() throws Exception {

        FireStation fireStation = new FireStation("address", "1");
        when(fireStationService.addFireStation(fireStation)).thenReturn(true);
        mockMvc.perform(post("/firestations?address=address&station=1"))
                .andExpect(status().isOk());

    }
 **/


    @Test
    public void deleteFirestationTest() throws Exception {

        FireStation fireStation = new FireStation("address", "1");
        when(fireStationService.deleteFireStation("address","1")).thenReturn(true);
        mockMvc.perform(delete("/firestations?address=address&station=1")).andExpect(status().isOk());
    }

    @Test
    public void updateFirestationTest() throws Exception {
        FireStation fireStation = new FireStation("address", "1");
        when(fireStationService.addFireStation(fireStation)).thenReturn(true);
        mockMvc.perform(put("/firestations?address=address&station=3"))
        .andExpect(status().isOk());
        verify(fireStationService,times(1)).updateFireStation("address","3");
    }

}

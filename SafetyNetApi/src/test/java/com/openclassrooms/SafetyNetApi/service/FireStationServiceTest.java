package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.repository.FireStationImpl;

import com.openclassrooms.SafetyNetApi.repository.FireStationRepository;
import org.junit.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@WebMvcTest(FireStationService.class)
@AutoConfigureMockMvc
public class FireStationServiceTest {


    @Autowired
    private FireStationService fireStationService;

    @MockBean
    private FireStationImpl fireStationImpl;

    @MockBean
    private FireStation fireStation;


    @Test
    public void getFirestationTest() {

        fireStation = new FireStation();
        fireStationImpl = new FireStationImpl();
        fireStationService = new FireStationService();

        fireStation.setAddress("address");
        fireStation.setStation("station");

       fireStationImpl.findAll();

       assertThat(fireStationService.getFireStation().size()!=0);

    }

    @Test
    public void updateFirestationTest(){

        fireStationImpl = new FireStationImpl();
        fireStationService = new FireStationService();
        fireStation = new FireStation();

        fireStation.setAddress("address");
        fireStation.setStation("station");

        Data.getFireStations().add(fireStation);

        assertTrue(fireStationService.updateFireStation("address","station"));
    }

    @Test
    public void deleteFirestationTest(){

        fireStationImpl = new FireStationImpl();
        fireStationService = new FireStationService();


        fireStation = new FireStation("address","station");

        Data.getFireStations().add(fireStation);

        fireStationImpl.deleteFireStation("address","station");

        assertThat(fireStationService.deleteFireStation("address","station")).doesNotHaveToString("address");



    }


    @Test
    public void addFirestationTest(){

        fireStationImpl = new FireStationImpl();
        fireStationService = new FireStationService();
        fireStation = new FireStation();

        fireStation.setAddress("address");
        fireStation.setStation("station");

        fireStationService.addFireStation(fireStation);

        Data.getFireStations().add(fireStation);

        assertThat(fireStationService.addFireStation(fireStation));
        assertThat(fireStation.getAddress()).isEqualTo("address");


    }

}

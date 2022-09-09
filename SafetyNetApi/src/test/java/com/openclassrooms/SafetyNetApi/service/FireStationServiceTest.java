package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.repository.FireStationImpl;
import com.openclassrooms.SafetyNetApi.repository.PersonRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)

public class FireStationServiceTest {


    @Mock
    private FireStationService fireStationService = new FireStationService();

    @Mock
    private FireStationImpl fireStationImpl = new FireStationImpl();

    @Mock
    private FireStation fireStation = new FireStation();


    @Test
    public void getFirestationTest() {

        fireStation.setAddress("address");
        fireStation.setStation("station");

        Data.getFireStations().add(fireStation);

        assertThat(fireStationService.getFireStation().size()!=0);

    }

    @Test
    public void updateFirestationTest(){

        fireStation = new FireStation();

        fireStation.setAddress("address");
        fireStation.setStation("station");

        Data.getFireStations().add(fireStation);

        assertThat(fireStationService.updateFireStation("address","station"));

    }

    @Test
    public void deleteFirestationTest(){

        fireStation.setAddress("address");
        fireStation.setStation("station");

        Data.getFireStations().add(fireStation);

        fireStationImpl.deleteFireStation("address","station");
        assertThat(fireStationService.getFireStation()).doesNotHaveToString("address");



    }

    @Test
    public void addFirestationTest(){

        fireStation = new FireStation();

        fireStation.setAddress("address");
        fireStation.setStation("station");

        fireStationService.addFireStation(fireStation);

        Data.getFireStations().add(fireStation);

        assertThat(fireStation.getAddress()).isEqualTo("address");
        assertThat(fireStation.getStation()).isEqualTo("station");


    }
}

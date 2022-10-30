package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirestationImplTest {

    private FireStationRepository fireStationImpl;

    @Test
    public void getFirestationImplTest(){

        FireStation fireStation = new FireStation();

        fireStation.setAddress("address");
        fireStation.setStation("1");

        FireStation fireStation1 = new FireStation();
        fireStation1.setAddress("address1");
        fireStation1.setStation("2");

        Data.getFireStations().add(fireStation);
        Data.getFireStations().add(fireStation1);

        List<FireStation> list = new ArrayList<>();
        list.add(fireStation);
        list.add(fireStation1);

        assertEquals(2, list.size());
    }

    @Test
    public void saveFirestationTest(){

        FireStation firestation = new FireStation();
        fireStationImpl = new FireStationRepository();

        firestation.setStation("1");
        firestation.setAddress("address");

        Data.getFireStations().add(firestation);

        assertTrue(fireStationImpl.updateFireStation("address","1"));
    }

    @Test
    public void deleteFirestationTest() {

        FireStation fireStation = new FireStation();
        fireStationImpl = new FireStationRepository();

        fireStation.setAddress("address");
        fireStation.setStation("1");

        Data.getFireStations().add(fireStation);
        assertTrue(fireStationImpl.deleteFireStation("address","1"));
    }

    @Test
    public void findAllTest() {

        FireStation fireStation = new FireStation();
        fireStationImpl = new FireStationRepository();

        fireStation.setStation("1");
        fireStation.setAddress("addresse");

        Data.getFireStations().add(fireStation);
        assertTrue(fireStationImpl.findAll().size() != 0);
    }


}

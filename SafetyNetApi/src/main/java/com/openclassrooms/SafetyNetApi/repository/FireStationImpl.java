package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FireStationImpl implements FireStationRepository {
    @Override
    public List<FireStation> findAll() {
        return Data.getFireStations();
    }

    @Override
    public FireStation addFireStation(FireStation fireStation) {
        FireStation fireStationToAdd = null;
        if (fireStationToAdd == null) {
            Data.getFireStations().add(fireStationToAdd);
        }

        return fireStationToAdd;
    }


    @Override
    public FireStation deleteFireStation(String adress, String station) {
        FireStation fireStationToDelete = null;
        for (FireStation fireStation : Data.getFireStations()) {
            if (fireStation.getAddress().equals(adress) && fireStation.getStation().equals(station)) {
                fireStationToDelete = fireStation;
            }

        }
        if (fireStationToDelete != null) {
            Data.getPersons().remove(fireStationToDelete);
            return null;
        }
        return null;
    }


    @Override
    public FireStation updateFireStation(String adress, String station) {
        FireStation fireStationToUpdate = null;
        for (FireStation fireStation : Data.getFireStations()) {
            if (fireStation.getAddress().equals(adress) && fireStation.getStation().equals(station)) {
                fireStation.getStation();
                fireStation.getAddress();
            }

        }
        return fireStationToUpdate;
    }
}


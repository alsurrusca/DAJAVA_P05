package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FireStationImpl implements FireStationRepository {
    @Override
    public List<FireStation> findAll() {
        return Data.getFireStations();
    }

    @Override
    public boolean addFireStation(FireStation fireStation) {
      return Data.getFireStations().add(fireStation);
    }


    @Override
    public boolean deleteFireStation(String adress, String station) {
        FireStation fireStationToDelete = null;
        for (FireStation fireStation : Data.getFireStations()) {
            if (fireStation.getAddress().equals(adress) && fireStation.getStation().equals(station)) {
                fireStationToDelete = fireStation;
            }

        }
        if (fireStationToDelete != null) {
            Data.getPersons().remove(fireStationToDelete);
            return true;
        }
        return false;
    }


    @Override
    public boolean updateFireStation(String address, String station) {
        for (FireStation fireStation : Data.getFireStations()) {
            if (fireStation.getAddress().equals(address) && fireStation.getStation().equals(station)) {
                fireStation.getStation();
                fireStation.getAddress();
                return true;
            }

        }
        return false;
    }

    public List<FireStation> getFireStationsByNumber(String station) {
        List<FireStation> fireStationsList = new ArrayList<>();

        for(FireStation fireStation : Data.getFireStations()){
            if(fireStation.getStation().equals(station)){
                fireStationsList.add(fireStation);
            }
        }

        return fireStationsList;
    }

    public List<FireStation> getFireStationsByNumber(List<String> station) {
        List<FireStation> fireStationsList = new ArrayList<>();

        for(FireStation fireStation : Data.getFireStations()){
            if(fireStation.getStation().equals(station)){
                fireStationsList.add(fireStation);
            }
        }

        return fireStationsList;
    }


    public List<FireStation> getFireStationByAddress(String address) {
       List<FireStation> fireStationListByAddress = new ArrayList<>();

       for(FireStation fireStation : Data.getFireStations()){
           if(fireStation.getAddress().equals(address)){
               fireStationListByAddress.add(fireStation);
           }
       }

       return fireStationListByAddress;
    }
}


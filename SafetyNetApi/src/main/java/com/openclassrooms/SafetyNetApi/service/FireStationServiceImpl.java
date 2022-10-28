package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.repository.FireStationRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FireStationServiceImpl {

    public List<FireStation> findAll() {
        return Data.getFireStations();
    }


    public boolean addFireStation(FireStation fireStation) {
      return Data.getFireStations().add(fireStation);
    }



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

    public List<FireStation> getFireStationByNumber(String station) {
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

        for(FireStation fireStation : Data.getFireStations()) {
            for (String stationId : station) {
                if (fireStation.getStation().equals(stationId)) {
                    fireStationsList.add(fireStation);
                }
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


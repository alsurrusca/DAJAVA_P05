package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationService {

    @Autowired
    private FireStationRepository fireStationRepository;

    public List<FireStation> getFireStation() {
        return fireStationRepository.findAll();
    }

    public List<FireStation> getFireStations() {
        return fireStationRepository.findAll();
    }

    public FireStation updateFireStation(
            String address,
            String station) {

        FireStation updateFireStation = fireStationRepository.updateFireStation(address, station);
        return updateFireStation;
    }

    public FireStation addFireStation(FireStation fireStation) {
        return fireStationRepository.addFireStation(fireStation);
    }

    public FireStation deleteFireStation(String address, String station) {
        return fireStationRepository.deleteFireStation(address, station);
    }
}


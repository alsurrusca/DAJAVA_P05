package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.repository.FireStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationService {

    @Autowired
    private FireStationRepository fireStationRepository = new FireStationRepository();

    public List<FireStation> getFireStation() {
        return fireStationRepository.findAll();
    }

    public boolean updateFireStation(
            String address,
            String station) {
        return fireStationRepository.updateFireStation(address,station);
    }

    public boolean addFireStation(FireStation fireStation) {
        return fireStationRepository.addFireStation(fireStation);
    }

    public boolean deleteFireStation(String address, String station) {
        return fireStationRepository.deleteFireStation(address, station);
    }



}


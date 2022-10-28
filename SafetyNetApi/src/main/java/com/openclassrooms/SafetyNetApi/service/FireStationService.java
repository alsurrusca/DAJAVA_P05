package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireStationService {

    @Autowired
    private FireStationServiceImpl fireStationService = new FireStationServiceImpl();

    public List<FireStation> getFireStation() {
        return fireStationService.findAll();
    }

    public boolean updateFireStation(
            String address,
            String station) {
        return fireStationService.updateFireStation(address,station);
    }

    public boolean addFireStation(FireStation fireStation) {
        return fireStationService.addFireStation(fireStation);
    }

    public boolean deleteFireStation(String address, String station) {
        return fireStationService.deleteFireStation(address, station);
    }



}


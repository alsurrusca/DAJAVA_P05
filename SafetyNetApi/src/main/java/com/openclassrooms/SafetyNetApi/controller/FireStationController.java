package com.openclassrooms.SafetyNetApi.controller;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.service.FireStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FireStationController {

    @Autowired
    private FireStationService fireStationService;

    /**
     * @Param firestation
     * @return list
     */

    @GetMapping("/firestations")
    public List<FireStation> getFireStation() {
        List<FireStation> listOfFireStation = fireStationService.getFireStation();
        return listOfFireStation;
    }


    @PostMapping("/firestations")
    public FireStation createFireStation (@RequestBody FireStation fireStation) {
        return fireStationService.addFireStation(fireStation);
    }


    @PutMapping("/firestations")
    public FireStation updateFireStation(@RequestParam String address, String station) {
        FireStation updateFireStation = fireStationService.updateFireStation(address, station);
        return updateFireStation;
    }


    @DeleteMapping("/firestations")
    public void deleteFireStation (@RequestParam String address, String station) {
        fireStationService.deleteFireStation(address,station);
    }


}

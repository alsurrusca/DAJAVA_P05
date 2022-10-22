package com.openclassrooms.SafetyNetApi.controller;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.service.FireStationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RestController
public class FireStationController {

    @Autowired
    private FireStationService fireStationService;
    Logger log = LoggerFactory.getLogger(FireStationController.class);

    /**
     * @Param firestation
     * @return list
     */

    @GetMapping("/firestations")
    public List<FireStation> getFireStation() {
        List<FireStation> listOfFireStation = fireStationService.getFireStation();
        if (listOfFireStation.isEmpty()) {
            log.error("Find all firestations request FAILED");
        } else {
            log.info("Find all firestations request SUCCESS");
        }
        return listOfFireStation;
    }


    @PostMapping("/firestations")
    public boolean createFireStation (@RequestBody FireStation fireStation) {
        log.info("Create firestations request SUCCESS");
        return fireStationService.addFireStation(fireStation);
    }


    @PutMapping("/firestations")
    public boolean updateFireStation(@RequestParam String address, String station) {
        boolean updateFireStation = fireStationService.updateFireStation(address, station);
        if (updateFireStation) {
            log.info("Update firestation request SUCCESS");
        } else {
            log.error("Update firestation request FAILED, the address doesn't exist");
        }        return updateFireStation;
    }


    @DeleteMapping("/firestations")
    public boolean deleteFireStation (@RequestParam String address, String station) {
        boolean deleteFire = fireStationService.deleteFireStation(address,station);
        if (deleteFire) {
            log.info("Delete firestation request SUCCESS");
        } else {
            log.error("Delete firestation request FAILED, the address doesn't exist");
        }
        return deleteFire;
    }


}

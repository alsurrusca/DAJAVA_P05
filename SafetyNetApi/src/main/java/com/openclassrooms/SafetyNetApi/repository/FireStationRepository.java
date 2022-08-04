package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FireStationRepository {
    List<FireStation> findAll();

    FireStation addFireStation (FireStation fireStation);

    FireStation deleteFireStation (String adress, String station);

    FireStation updateFireStation (String adress, String station);


}

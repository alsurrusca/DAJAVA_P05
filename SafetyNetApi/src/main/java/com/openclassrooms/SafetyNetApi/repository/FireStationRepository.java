package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FireStationRepository {

    List<FireStation> findAll();

    boolean addFireStation (FireStation fireStation);

    boolean deleteFireStation (String adress, String station);

    boolean updateFireStation (String adress, String station);


}

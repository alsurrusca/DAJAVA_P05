package com.openclassrooms.SafetyNetApi.dto;

import com.openclassrooms.SafetyNetApi.model.FireStation;

import java.util.ArrayList;
import java.util.List;

public class FirestationAdressListDTO {

    private List<String> firestationList = new ArrayList<>();
    private List<FireStation> firestation;

    public List<String> getFirestationList() {
        return firestationList;
    }

    public void setFirestationList(List<String> firestationList) {
        this.firestationList = firestationList;
    }

    public List<FireStation> getFirestation() {
        return firestation;
    }

    public void setFirestation(List<FireStation> firestation) {
        this.firestation = firestation;
    }
}

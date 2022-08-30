package com.openclassrooms.SafetyNetApi.dto;

import com.openclassrooms.SafetyNetApi.model.FireStation;

import java.util.ArrayList;
import java.util.List;

public class FirestationAdressListDTO {

    private int station;
    private List<FireAddressDTO> personList = new ArrayList<>();


    public int getStation() {
        return station;
    }

    public void setStation(int station) {
        this.station = station;
    }

    public List<FireAddressDTO> getPersonList() {
        return personList;
    }

    public void setPersonList(List<FireAddressDTO> personList) {
        this.personList = personList;
    }

}

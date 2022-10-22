package com.openclassrooms.SafetyNetApi.dto;

import java.util.ArrayList;
import java.util.List;

public class FirestationAdressListDTO {

    private String station;
    private List<FireAddressDTO> personList = new ArrayList<>();


    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public List<FireAddressDTO> getPersonList() {
        return personList;
    }

    public void setPersonList(List<FireAddressDTO> personList) {
        this.personList = personList;
    }

}

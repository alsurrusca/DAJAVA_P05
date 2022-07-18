package com.openclassrooms.SafetyNetApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.File;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FireStation {

    String address;
    String station;

    public FireStation(String address, String station){

        this.address = address;
        this.station = station;
    }
}

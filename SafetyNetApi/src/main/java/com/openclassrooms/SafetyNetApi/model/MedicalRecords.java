package com.openclassrooms.SafetyNetApi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class MedicalRecords {

    private String firstName;
    private String lastName;
    private String birthdate;
    private String medications;
    private String allergies;


    public MedicalRecords(String firstName, String lastName, String birthdate, String medications, String allergies){

        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.medications = medications;
        this.allergies = allergies;
    }
}

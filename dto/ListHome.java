package com.openclassrooms.SafetyNetApi.dto;

import com.openclassrooms.SafetyNetApi.model.Person;

import java.util.List;

public class ListHome {

    private String firstName;
    private String lastName;

    public ListHome(String firstname, String lastname) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    public ListHome() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}


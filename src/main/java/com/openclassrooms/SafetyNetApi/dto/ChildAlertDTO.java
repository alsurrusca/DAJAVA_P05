package com.openclassrooms.SafetyNetApi.dto;

import com.openclassrooms.SafetyNetApi.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ChildAlertDTO {

    private String firstName;
    private String lastName;
    private Integer age;
    private String home;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setHome(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

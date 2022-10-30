package com.openclassrooms.SafetyNetApi.dto;

import com.openclassrooms.SafetyNetApi.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ChildAlertDTO  {

    private String firstName;
    private String lastName;
    private Integer age;
    private List<ListHome> home = new ArrayList<>();

    public ChildAlertDTO(String firstName, String lastName, Integer age, List home){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.home = home;

    }

    public ChildAlertDTO() {

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

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public List<ListHome> getHome (){return home;}

    public void setHome(List<ListHome> adult) {
       this.home = adult;
    }
}

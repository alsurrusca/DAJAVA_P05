package com.openclassrooms.SafetyNetApi.dto;

public class PersonByStationDTO {

    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
    private String phone;
    private String medication;
    private String allergies;

    public PersonByStationDTO(String firstname, String lasrname, String address, String phone, String allergies) {
        this.firstName = firstname;
        this.lastName = lasrname;
        this.address = address;
        this.phone = phone;
        this.allergies = allergies;
    }

    public  PersonByStationDTO(){}

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

       public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }




}

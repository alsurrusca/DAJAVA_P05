package com.openclassrooms.SafetyNetApi.dto;

public class FirestationStationNumberDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private Integer age;

    public FirestationStationNumberDTO(String firstname, String lastname, Integer age, String address, String phone) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.address = address;
        this.phone = phone;
        this.age = age;
    }

    public FirestationStationNumberDTO() {}

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

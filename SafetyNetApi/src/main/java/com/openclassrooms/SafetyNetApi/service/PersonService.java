package com.openclassrooms.SafetyNetApi.service;


import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonServiceImpl personService = new PersonServiceImpl();

    public List<Person> getPersons() {
        return personService.findAll();
    }


    public boolean updatePerson(
            String address,
            String city,
            String zip,
            String phone,
            String email) {
        return personService.updatePerson(address, city, zip, phone, email);
    }

    public boolean deletePerson(String firstName, String lastName) {
        return personService.deletePerson(firstName, lastName);
    }

    public boolean addPerson (Person person) {
        return personService.addPerson(person);
    }




}

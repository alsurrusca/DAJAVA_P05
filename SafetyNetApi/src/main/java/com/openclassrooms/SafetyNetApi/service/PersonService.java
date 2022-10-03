package com.openclassrooms.SafetyNetApi.service;


import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.repository.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonRepositoryImpl personRepository = new PersonRepositoryImpl();

    public List<Person> getPersons() {
        return personRepository.findAll();
    }


    public boolean updatePerson(
            String address,
            String city,
            String zip,
            String phone,
            String email) {
        return personRepository.updatePerson(address, city, zip, phone, email);
    }

    public boolean deletePerson(String firstName, String lastName) {
        return personRepository.deletePerson(firstName, lastName);
    }

    public boolean addPerson (Person person) {
        return personRepository.addPerson(person);
    }




}

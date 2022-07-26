package com.openclassrooms.SafetyNetApi.service;


import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    public Person updatePerson(
            String address,
            String city,
            String zip,
            String phone,
            String email) {
        Person updatePerson = personRepository.update(address, city, zip, phone, email);
        return updatePerson;
    }

    public Person deletePerson(String firstName, String lastName) {
        return personRepository.deletePerson(firstName, lastName);
    }

    public Person savePerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return savedPerson;
    }


}

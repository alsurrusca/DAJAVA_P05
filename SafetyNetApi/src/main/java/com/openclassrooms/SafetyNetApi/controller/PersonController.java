package com.openclassrooms.SafetyNetApi.controller;


import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.service.PersonService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static aQute.bnd.osgi.Processor.log;

@RestController

public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * Read - Get all Person
     *
     * @Return - A List object of Person
     */

    @GetMapping("/person")
    public List<Person> getPersons() {
        List<Person> listOfPerson = personService.getPersons();
        return listOfPerson;
    }


    /**
     * Create - Add a new person
     *
     * @param person - A object person
     * @return - The person object save
     */

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }


    @PutMapping("/person")
    public Person updatePerson(@RequestParam String address, String city, String zip, String phone, String email) {
        Person updatePerson = personService.updatePerson(address, city, zip, phone, email);
        return updatePerson;
    }


    @DeleteMapping("/person")
    public void deletePerson(@RequestParam String firstName, String lastName) {
        personService.deletePerson(firstName, lastName);
    }


}

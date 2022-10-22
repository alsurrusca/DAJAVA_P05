package com.openclassrooms.SafetyNetApi.controller;


import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.service.PersonService;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static aQute.bnd.osgi.Processor.log;

@Slf4j
@RestController

public class PersonController {

    @Autowired
    private PersonService personService = new PersonService();
    Logger log = LoggerFactory.getLogger(PersonController.class);

    /**
     * Read - Get all Person
     *
     * @Return - A List object of Person
     */

    @GetMapping("/person")
    public List<Person> getPersons() {
        List<Person> listOfPerson = personService.getPersons();
        if(listOfPerson.isEmpty()){
            log.error("Find All Persons request FAILED");
        } else {
            log.info("Find all Persons request SUCCESS");
        }
        return listOfPerson;
    }


    /**
     * Create - Add a new person
     *
     * @param person - A object person
     * @return - The person object save
     */

    @PostMapping("/person")
    public boolean createPerson(@RequestBody Person person) {

        log.info("Post Person request SUCCESS");

        return personService.addPerson(person);
    }


    @PutMapping("/person")
    public boolean updatePerson(@RequestParam String address, String city, String zip, String phone, String email) {
        boolean updatePerson = personService.updatePerson(address, city, zip, phone, email);
        if(updatePerson){
            log.info("Update  person request SUCCESS");
        } else {
            log.error("Update person request FAILED");
        }
        return updatePerson;
    }


    @DeleteMapping("/person")
    public void deletePerson(@RequestParam String firstName, String lastName) {
        boolean deletePerson = personService.deletePerson(firstName, lastName);
        if(deletePerson){
            log.info("Delete person request SUCCESS");
        } else {
            log.info("Delete person request FAILED");
        }
    }


}

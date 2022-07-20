package com.openclassrooms.SafetyNetApi.controller;

import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     * Read - Get all Person
     * @Return - A List object of Person
     */

    @GetMapping("/persons")
    public List<Person> getPersons(){
        List<Person> listOfPerson = personService.getPersons();
        return listOfPerson;
    }

    /**
     * Create - Add a new person
     * @param person - A object person
     * @return - The person object save
     */

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return personService.savePerson(person);
    }

    /**
     * Update - Update person
     * @param address
     * @param city
     * @param zip
     * @param phone
     * @param email
     * @return
     */
    @PutMapping("/person")
    public Person updatePerson(@RequestParam String address,String city,String zip, String phone, String email ){
        Person updatePerson = personService.updatePerson(address, city, zip, phone, email);
        return updatePerson;
    }

    /**
     * Delete - Delete person with his firstName and lastName
     * @param firstName
     * @param lastName
     */

    @DeleteMapping("/person")
    public void deletePerson(@RequestParam String firstName, String lastName){
        personService.deletePerson(firstName,lastName);
    }
}

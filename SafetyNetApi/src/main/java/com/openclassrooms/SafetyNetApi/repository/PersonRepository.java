package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.stereotype.Repository;


import java.util.List;


public interface PersonRepository {


    List<Person> findAll();

    Person deletePerson(String firstName, String lastName);

    Person addPerson (Person person);

    Person update(String address, String city, String zip,String phone, String email);

    public List<Person> getPersonListByName(String firstName, String lastName);

    List<Person> getPersonByAddress (String address);

}

package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.stereotype.Repository;


import java.util.List;


public interface PersonRepository {


    List<Person> findAll();

    boolean deletePerson(String firstName, String lastName);

    boolean addPerson (Person person);

    boolean updatePerson(String address, String city, String zip, String phone, String email);

     List<Person> getPersonListByName(String firstName, String lastName);

    List<Person> getPersonByAddress (String address);

}

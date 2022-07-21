package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository
public interface PersonRepository extends CrudRepository<Person, String>{


    List<Person> findAll();

    Person deletePerson(String firstName, String lastName);

    Person save(Person person);

    Person update(String address, String city, String zip,String phone, String email);
}

package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository {


    List<Person> findAll();

    Person deletePerson(String firstName, String lastName);

    Person save(Person person);

    Person update(String firstName, String lastName, String address, String city, String zip);
}

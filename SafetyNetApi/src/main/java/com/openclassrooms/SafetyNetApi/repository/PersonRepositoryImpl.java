package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Override
    public List<Person> findAll() {
        return Data.getPersons();
    }

    @Override
    public Person addPerson (Person person) {

        Person personToAdd = null;
        if(personToAdd == null){
            Data.getPersons().add(personToAdd);
        }

        return personToAdd;
    }

    @Override
    public Person deletePerson(String firstName, String lastName) {
        Person personToDelete = null;
        for (Person person : Data.getPersons()) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
                personToDelete = person;
            }

        }
        if(personToDelete != null){
            Data.getPersons().remove(personToDelete);
            return null;
        }
        return null;
    }





    @Override
    public Person update(String address, String city, String zip,String phone, String email) {
        Person personToUpdate = null;
        for (Person person1 : Data.getPersons()) {
            if (person1.getFirstName().equals(person1.getFirstName()) && person1.getLastName().equals(person1.getLastName())) {
                personToUpdate.getAddress();
                personToUpdate.getCity();
                personToUpdate.getZip();
                personToUpdate.getEmail();
                personToUpdate.getPhone();
            }

        }
        return personToUpdate;
    }
}


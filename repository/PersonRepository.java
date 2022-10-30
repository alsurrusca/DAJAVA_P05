package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {

    public List<Person> findAll() {
        return Data.getPersons();
    }


    public boolean addPerson(Person person) {

        return Data.getPersons().add(person);
    }

    public boolean deletePerson (String firstName, String lastName){
    Person personToDelete = null;
        for (Person person : Data.getPersons()) {
        if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName)) {
            personToDelete = person;
        }

    }
        if (personToDelete != null) {
        Data.getPersons().remove(personToDelete);
        return true;
    }
        return false;
}



    public boolean updatePerson(String address, String city, String zip, String phone, String email) {
        Person personToUpdate = new Person();
        for (Person person1 : Data.getPersons()) {
            if (person1.getFirstName().equals(person1.getFirstName()) && person1.getLastName().equals(person1.getLastName())) {
                personToUpdate.getAddress();
                personToUpdate.getCity();
                personToUpdate.getZip();
                personToUpdate.getEmail();
                personToUpdate.getPhone();

                return true;
            }

        }
        return false;
    }

    public List<Person> getPersonListByName(String firstName, String lastName) {
        List<Person> personList = new ArrayList<>();
        for (Person person : Data.getPersons()) {
            if (person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                personList.add(person);
        }

        return personList;
    }

    public List<Person> getPersonByAddress (String address){
        List<Person> personListByAddress = new ArrayList<>();
        for(Person person : Data.getPersons()){
            if(person.getAddress().equals(address)){
                personListByAddress.add(person);
            }
        }
        return personListByAddress;
    }


}

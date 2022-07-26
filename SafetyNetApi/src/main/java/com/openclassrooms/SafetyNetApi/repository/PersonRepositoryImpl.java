package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

        @Override
        public List<Person> findAll() {
            return null;
        }

        @Override
        public Person deletePerson(String firstName, String lastName) {
            return null;
        }

        @Override
        public Person save(Person person) {
            return null;
        }

        @Override
        public Person update(String address, String city, String zip, String phone, String email) {
            return null;
        }
    }


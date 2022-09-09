package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.Person;

import com.openclassrooms.SafetyNetApi.repository.PersonRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService = new PersonService();

    private Person person = new Person();


    private PersonRepositoryImpl personRepository = new PersonRepositoryImpl();


    @Test
    public void getPersonTest(){

        //WHEN

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        Data.getPersons().add(person);

        //Then
        assertThat(personService.getPersons().size() != 0);

    }

    @Test
    public void updatePersonTest(){


        //When
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        Data.getPersons().add(person);

        assertThat(personService.updatePerson("address","city","zip","12345678","email@email.com")).isEqualTo(person);

    }

    @Test
    public void deletePersonTest(){



        //When
        //On ajoute une nouvelle personne pour le test
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        Data.getPersons().add(person);

        personRepository.deletePerson("firstName", "lastName");

        assertThat(personService.getPersons()).doesNotHaveToString("firstName");




    }

    @Test
    public void addPersonTest(){

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        Data.getPersons().add(person);

        assertThat(person.getFirstName()).isEqualTo("firstName");

    }
}

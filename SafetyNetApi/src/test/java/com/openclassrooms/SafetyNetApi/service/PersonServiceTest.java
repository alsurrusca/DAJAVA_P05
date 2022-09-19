package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.Person;

import com.openclassrooms.SafetyNetApi.repository.PersonRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



@WebMvcTest(PersonService.class)
@AutoConfigureMockMvc
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private Person person;

    @MockBean
    private PersonRepositoryImpl personRepository;


    @Test
    public void getPersonTest(){
        person = new Person();

        //WHEN

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        //Then

        List<Person> persons = new ArrayList<Person>();
        persons.add(person);

        Mockito.when(personRepository.findAll()).thenReturn(persons);

        assertThat(personService.getPersons().size() != 0);
    }

    @Test
    public void updatePersonTest(){
        person = new Person();

        //When
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        List<Person> updatePerson = new ArrayList<Person>();
        updatePerson.add(person);

        Mockito.when(personRepository.update("address","city","zip","12345678","email@email.com")).thenReturn(person);

        assertThat(personService.updatePerson("address","city","zip","12345678","email@email.com")).isEqualTo(person);
    }


    @Test
    public void deletePersonTest(){

       person = new Person();


        //When
        //On ajoute une nouvelle personne pour le test
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");


        Mockito.when(personRepository.deletePerson("firstName","lastName")).thenReturn(person);
        personRepository.deletePerson("firstName", "lastName");

        assertThat(personService.getPersons()).doesNotHaveToString("firstName");




    }

    @Test
    public void addPersonTest(){

        personService = new PersonService();
        person = new Person();

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        Mockito.when(personRepository.addPerson(person)).thenReturn(person);
        assertThat(personRepository.addPerson(person)).isEqualTo(person);

    }
}

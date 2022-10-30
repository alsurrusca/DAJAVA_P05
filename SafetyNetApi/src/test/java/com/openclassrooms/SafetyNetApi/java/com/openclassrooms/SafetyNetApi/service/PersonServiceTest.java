package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.model.Person;

import com.openclassrooms.SafetyNetApi.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@WebMvcTest(PersonService.class)
@AutoConfigureMockMvc
public class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @MockBean
    private Person person;

    @MockBean
    private PersonRepository personRepository;


    @Test
    public void getPersonTest() {
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

        personRepository.findAll();
        assertThat(personService.getPersons().size()!= 0);

    }

    @Test
    public void updatePersonTest() {

        personService = new PersonService();
        personRepository = new PersonRepository();

        //When
        person = new Person("firstname", "lastname", "address", "city", "zip", "12345678", "email@email.com");

        Data.getPersons().add(person);

        String address1 = "address1";
        person = new Person("firstname", "lastname", address1, "city", "zip", "12345678", "email@email.com");


        assertTrue(personService.updatePerson(address1, "city", "zip", "12345678", "email@email.com"));
    }


    @Test
    public void deletePersonTest() {

        personRepository = new PersonRepository();

        person = new Person("firstName","lastName","address","city","zip","phone","email@email.com");
        //When
        //On ajoute une nouvelle personne pour le test
        /**person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

         **/
        Data.getPersons().add(person);
        //List<Person> persons = new ArrayList<>();
        //persons.add(person);

        //Mockito.when(Data.getPersons()).thenReturn(persons);

        personService.deletePerson("firstName", "lastName");

        assertThat(personService.deletePerson("fistName", "lastName")).doesNotHaveToString("firstName");


    }

    @Test
    public void addPersonTest() {

        personService = new PersonService();
        person = new Person();
        personRepository = new PersonRepository();

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        personService.addPerson(person);

        Data.getPersons().add(person);

        assertTrue(personService.addPerson(person));
        assertThat(person.getFirstName()).isEqualTo("firstName");

    }

}

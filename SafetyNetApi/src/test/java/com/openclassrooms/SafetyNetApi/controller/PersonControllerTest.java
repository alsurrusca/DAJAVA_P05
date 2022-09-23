package com.openclassrooms.SafetyNetApi.controller;

import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.service.PersonService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
@WebMvcTest(PersonController.class)
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)

public class PersonControllerTest {

    @MockBean
    private PersonService personService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext context){
        MockitoAnnotations.initMocks(this);
        PersonController personController = new PersonController();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getPersonTest() throws Exception {
        if(mockMvc==null){
            throw new Exception("mvc is having null value");
        }

        mockMvc = null;

        mockMvc.perform(get("/person")).andExpect((status().isOk()));


    }

    @Test
    public void createPersonTest() throws Exception{

        personService = new PersonService();

        //On crée une nouvelle personne
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        List<Person> persons = new ArrayList<Person>();
        persons.add(person);

        Mockito.when(personService.addPerson(person)).thenReturn(true);

                mockMvc.perform(post("/person?firstName=firstName&lastName=lastName&address=address&city=city&zip=zip&phone=phone&email=email@email.com"))
               .andExpect(status().isOk());
    }
    @Test
    public void updatePersonTest() throws Exception {

        personService = new PersonService();

        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

       Mockito.when(personService.addPerson(person)).thenReturn(true);
        mockMvc.perform(put("/person?firstName=firstName&lastName=lastName&address=address1&city=city&zip=zip&phone=phone&email=email@email.com"))
        .andExpect(status().isOk());

        verify(personService.updatePerson("address1","city","zip","phone","email@email.com"));
    }

@Test
    public void deletePersonTest() throws Exception {

    personService = new PersonService();
    Person person = new Person();
    person.setFirstName("firstName");
    person.setLastName("lastName");
    person.setAddress("address");
    person.setCity("city");
    person.setZip("Zip");
    person.setEmail("email@email.com");
    person.setPhone("12345678");

    Mockito.when(personService.deletePerson("firstName","lastName")).thenReturn(true);

    mockMvc.perform(delete("/person?firstName=firstName&lastName=lastName")).andExpect(status().isOk());

}
}
**/
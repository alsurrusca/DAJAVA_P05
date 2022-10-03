package com.openclassrooms.SafetyNetApi.controller;


import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)

public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private PersonService personService;


    @Test
    public void getPersonTest() throws Exception {


        mockMvc.perform(get("/person")).andExpect((status().isOk()));


    }
/**
    @Test
    public void createPersonTest() throws Exception{

    Person person = new Person("firstName", "lastName", "address", "city", "zip", "phone", "email");

    when(personService.addPerson(person)).thenReturn(true);
    mockMvc.perform(post("/person?firstName=firstName&lastName=lastName&address=address&city=city&zip=zip&phone=phone&email=email"))
            .andExpect(status().isOk());

}
 **/
    @Test
    public void updatePersonTest() throws Exception {

        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        when(personService.addPerson(person)).thenReturn(true);
        mockMvc.perform(put("/person?firstName=firstName&lastName=lastName&address=address1&city=city&zip=zip&phone=phone&email=email@email.com"))
                .andExpect(status().isOk());

        verify(personService,times(1)).updatePerson("address1", "city", "zip", "phone", "email@email.com");
    }



    @Test
    public void deletePersonTest() throws Exception {

        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("Zip");
        person.setEmail("email@email.com");
        person.setPhone("12345678");

        when(personService.deletePerson("firstName", "lastName")).thenReturn(true);

        mockMvc.perform(delete("/person?firstName=firstName&lastName=lastName")).andExpect(status().isOk());

    }
}


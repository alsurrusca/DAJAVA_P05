package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.repository.PersonRepositoryImpl;
import com.openclassrooms.SafetyNetApi.repository.UrlImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
public class UrlServiceTest {

    Person person = new Person();

    @Mock
    UrlService urlService = new UrlService();

    @Mock
    UrlImpl urlImpl = new UrlImpl();

    @Mock
    PersonRepositoryImpl personRepository = new PersonRepositoryImpl();

    @Test
    public void getChildListByAddressTest(){

        Person person = new Person();

       //On créer une nouvelle personne
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        urlImpl.getChildListByAdress("address");
        assertThat(urlService.getChildListByAddress("address").size()!=0);



    }

    @Test
    public void getPersonInfoTest(){
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        List<Person> listOfPerson = new ArrayList<>();
        listOfPerson.add(person);

        assertThat(urlService.getPersonInfo("firstName","lastName").size()!=0);



    }

    @Test
    public void getPhoneNumberFromStationTest(){

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        FireStation fireStation = new FireStation();
        fireStation.setStation("1");
        fireStation.setAddress("address");

        urlImpl.getPhoneNumberListByStation("1");

        assertThat(urlService.getPhoneNumberFromStation("1")).isNotNull();

    }

    @Test
    public void getPersonListByAddressTest(){

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        urlImpl.getPersonListByAddress("address");

        assertThat(urlService.getPersonListByAddress("address")).isEqualTo(urlImpl.getPersonListByAddress("address"));

    }

    @Test
    public void getPersonFromStationNumber(){

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        FireStation fireStation = new FireStation();
        fireStation.setStation("1");
        fireStation.setAddress("address");



        urlImpl.getPersonFromStation(fireStation.getStation());

        assertThat(urlService.getPersonFromStationNumber(String.valueOf(fireStation))).isNotNull();
    }

    @Test
    public void getCommunityEmailListTest(){



        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        urlImpl.getCommunityEmailList("city");

        assertThat(urlService.getListFromMail("city")).isNotNull();

    }

    @Test
    public void getHomeByStationTest(){

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        FireStation fireStation = new FireStation();
        fireStation.setStation("1");

        List<String> fireStationStation = new ArrayList<>();
        fireStationStation.add(fireStation.getStation());

        urlImpl.getHomeByStationNumber(String.valueOf(fireStationStation));

        assertThat(urlService.getHomeByStation(String.valueOf(fireStationStation))).isNotNull();

    }
}

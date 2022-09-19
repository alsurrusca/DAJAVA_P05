package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.dto.ListHome;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.repository.PersonRepositoryImpl;
import com.openclassrooms.SafetyNetApi.repository.UrlImpl;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@WebMvcTest(UrlService.class)
@AutoConfigureMockMvc
public class UrlServiceTest {

   /** Person person = new Person();


    UrlService urlService = new UrlService();

    @Mock
    UrlImpl urlImpl;


    @Test
    public void getChildListByAddressTest() {

        Person person = new Person();
        urlImpl = new UrlImpl();

        //On créer une nouvelle personne
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        urlImpl.getChildListByAdress("address");
        assertThat(urlService.getChildListByAddress("address").size() != 0);


    }

    @Test
    public void getPersonInfoTest() {
        urlImpl = new UrlImpl();
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        List<Person> listOfPerson = new ArrayList<Person>();
        listOfPerson.add(person);

        assertThat(urlService.getPersonInfo("firstName", "lastName").size() != 0);


    }

    @Test
    public void getPhoneNumberFromStationTest() {

        urlImpl = new UrlImpl();

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

        //assertThat(urlService.getPhoneNumberFromStation("1")).isNotNull();

    }

    @Test
    public void getPersonListByAddressTest() {

        urlImpl = new UrlImpl();

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        urlImpl.getPersonListByAddress("address");

        assertThat(urlService.getPersonListByAddress("address")).isNotNull();

    }

    @Test
    public void getPersonFromStationNumberTest() {

        urlImpl = new UrlImpl();

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


        urlImpl.getPersonFromStation("1");

        assertThat(urlService.getPersonFromStationNumber("1")).isNotNull();
    }

    @Test
    public void getCommunityEmailListTest() {

        urlImpl = new UrlImpl();
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
    public void getHomeByStationTest() {

        urlImpl = new UrlImpl();
        List<ListHome> homeByStationNumber = new ArrayList<>();
        Person person = new Person();

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

        FireStation fireStation1 = new FireStation();
        fireStation1.setStation("2");
        fireStation1.setAddress("address2");

        List<String> fireStationStation = new ArrayList<String>();
        fireStationStation.add(fireStation.getStation());
        fireStationStation.add(fireStation1.getStation());

        urlImpl.getHomeByStationNumber(fireStationStation);

        assertThat(urlService.getHomeByStation(fireStationStation)).isNotNull();

    }
**/
}

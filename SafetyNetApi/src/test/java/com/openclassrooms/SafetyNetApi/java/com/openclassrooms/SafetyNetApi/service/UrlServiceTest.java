package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.dto.ListHome;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.model.Person;
import org.junit.Test;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@WebMvcTest(UrlService.class)
@AutoConfigureMockMvc
public class UrlServiceTest {

    private Person person = new Person();

    @MockBean
    private UrlService urlService;


    UrlService urlImpl;


    @Test
    public void getChildListByAddressTest() {


        urlImpl = new UrlService();
        urlService = new UrlService();

        //On créer une nouvelle personne
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        List<String> medication = List.of("medication");
        List<String>allergies = List.of("allergie");

        MedicalRecord medicalRecord = new MedicalRecord("firstname","lastname","01/23/4567",medication,allergies);


        urlImpl.getChildListByAdress("address");
        assertThat(urlService.getChildListByAdress("address").size() != 0);


    }


    @Test
    public void getPersonInfoTest() {
        urlImpl = new UrlService();
        urlService = new UrlService();


        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        List<Person> listOfPerson = new ArrayList<Person>();
        listOfPerson.add(person);

        assertThat(urlService.getPersonListInfo("firstName", "lastName").size() != 0);


    }

    @Test
    public void getPhoneNumberFromStationTest() {

        urlImpl = new UrlService();
        urlService = new UrlService();

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

        assertThat(urlService.getPhoneNumberListByStation("1")).isNotNull();

    }

    @Test
    public void getPersonListByAddressTest() {

        urlImpl = new UrlService();
        urlService = new UrlService();

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
    public void getCommunityEmailListTest() {

        urlImpl = new UrlService();
        urlService = new UrlService();

        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAddress("address");
        person.setCity("city");
        person.setZip("zip");
        person.setPhone("01234567");
        person.setEmail("email@email.com");

        urlImpl.getCommunityEmailList("city");

        assertThat(urlService.getCommunityEmailList("city")).isNotNull();

    }

    @Test
    public void getHomeByStationTest() {

        urlImpl = new UrlService();
        urlService = new UrlService();
        List<ListHome> homeByStationNumber = new ArrayList<>();

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

        List<String> fireStationStationNumber = new ArrayList<String>();
        fireStationStationNumber.add(fireStation.getStation());
        fireStationStationNumber.add(fireStation1.getStation());

        urlImpl.getHomeByStationNumber(fireStationStationNumber);

        assertThat(urlService.getHomeByStationNumber(fireStationStationNumber)).isNotNull();

    }

}

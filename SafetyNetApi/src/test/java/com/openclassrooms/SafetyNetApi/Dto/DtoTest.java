package com.openclassrooms.SafetyNetApi.Dto;


import com.openclassrooms.SafetyNetApi.dto.ListPersonFireStationByAddressDTO;
import com.openclassrooms.SafetyNetApi.dto.ListHome;
import com.openclassrooms.SafetyNetApi.dto.PersonByStationDTO;
import com.openclassrooms.SafetyNetApi.dto.ChildAlertDTO;
import com.openclassrooms.SafetyNetApi.dto.PersonInfoDTO;
import com.openclassrooms.SafetyNetApi.dto.FirestationStationNumberDTO;
import com.openclassrooms.SafetyNetApi.dto.AddressDTO;
import com.openclassrooms.SafetyNetApi.dto.FireAddressDTO;






import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DtoTest {

    @Test
    public void listHomeDtoTest() {

        ListHome listHome = new ListHome("firstname","lastname");
        listHome.getLastName();
        listHome.getFirstName();
        ListHome listHome1 = new ListHome();
        listHome1.setFirstName("firstnme");
        listHome1.setLastName("lastname");


        assertNotNull(listHome);
        assertNotNull(listHome1);


    }

    @Test
    public void childAlertDtoTes() {

        ChildAlertDTO childAlertDTO = new ChildAlertDTO();
        List<ListHome> home = new ArrayList<>();
        childAlertDTO.setFirstName("firstname");
        childAlertDTO.setLastName("lastname");
        childAlertDTO.setAge(20);
        childAlertDTO.setHome(home);

        ChildAlertDTO childAlertDTO1 = new ChildAlertDTO("firstName","lastname",12,home);
        childAlertDTO1.getFirstName();
        childAlertDTO.getLastName();
        childAlertDTO.getAge();
        childAlertDTO.getHome();

        assertNotNull(childAlertDTO);
        assertNotNull(childAlertDTO1);

    }



    @Test
    public void personInfoDtoTest() {

        List<String> medications = List.of("medication");
        List<String> allergies = List.of("allergie");
       PersonInfoDTO personInfoDTO = new PersonInfoDTO("firstname","lastname",10,"address","email",medications,allergies);
        personInfoDTO.getFirstName();
        personInfoDTO.getLastName();
        personInfoDTO.getAge();
        personInfoDTO.getAddress();
        personInfoDTO.getAllergies();
        personInfoDTO.getMedications();
        personInfoDTO.getMail();

        PersonInfoDTO personInfoDTO1 = new PersonInfoDTO();
        personInfoDTO1.setFirstName("name");
        personInfoDTO1.setLastName("lastname1");
        personInfoDTO1.setAge(15);
        personInfoDTO1.setAddress("address");
        personInfoDTO1.setMail("mail");
        personInfoDTO1.setAllergies(allergies);
        personInfoDTO1.setMedications(medications);

        assertNotNull(personInfoDTO1);

    }

    @Test
    public void listPersonFireStationByAddressDtoTest() {

        List<String> medications = List.of("medication");
        List<String> allergies = List.of("allergie");
        ListPersonFireStationByAddressDTO listPersonFireStationByAddressDTO = new ListPersonFireStationByAddressDTO("firstname","lastname",15,medications,allergies);
        listPersonFireStationByAddressDTO.getFirstName();
        listPersonFireStationByAddressDTO.getLastName();
        listPersonFireStationByAddressDTO.getAge();
        listPersonFireStationByAddressDTO.getAllergies();
        listPersonFireStationByAddressDTO.getMedications();

        ListPersonFireStationByAddressDTO listPersonFireStationByAddressDTO1 = new ListPersonFireStationByAddressDTO();



        listPersonFireStationByAddressDTO1.setFirstName("name");
        listPersonFireStationByAddressDTO1.setLastName("name");
        listPersonFireStationByAddressDTO1.setAge(15);
        listPersonFireStationByAddressDTO1.setAllergies(allergies);
        listPersonFireStationByAddressDTO1.setMedications(medications);

        assertNotNull(listPersonFireStationByAddressDTO);
        assertNotNull(listPersonFireStationByAddressDTO1);

    }
    @Test
    public void personByStationDtoTest() {

        PersonByStationDTO personByStationDTO = new PersonByStationDTO("firstname","lasrname","address","phone","allergies");
        personByStationDTO.getFirstName();
        personByStationDTO.getLastName();
        personByStationDTO.getPhone();
        personByStationDTO.getAddress();
        personByStationDTO.getAllergies();

        PersonByStationDTO personByStationDTO1 = new PersonByStationDTO();
        personByStationDTO1.setFirstName("firstname");
        personByStationDTO1.setLastName("name");
        personByStationDTO1.setAddress("address");
        personByStationDTO1.setPhone("phone");
        personByStationDTO1.setAllergies("allergies");

        assertNotNull(personByStationDTO);
        assertNotNull(personByStationDTO1);

    }

    @Test
    public void firestationNumberDtoTest() {

      FirestationStationNumberDTO firestationStationNumberDTO = new FirestationStationNumberDTO("firstname","lastname",15, "address","phone") ;
      firestationStationNumberDTO.getFirstName();
      firestationStationNumberDTO.getLastName();
      firestationStationNumberDTO.getAge();
      firestationStationNumberDTO.getAddress();
      firestationStationNumberDTO.getPhone();

      FirestationStationNumberDTO firestationStationNumberDTO1 = new FirestationStationNumberDTO();
      firestationStationNumberDTO1.setFirstName("firstname");
      firestationStationNumberDTO1.setLastName("lastname");
      firestationStationNumberDTO1.setAddress("address");
      firestationStationNumberDTO1.setAge(15);
      firestationStationNumberDTO1.setPhone("phone");

      assertNotNull(firestationStationNumberDTO);
      assertNotNull(firestationStationNumberDTO1);
    }

    public void addressDtoTest(){
        List<String> medications = List.of("medication");
        List<String> allergies = List.of("allergie");
       AddressDTO addressDTO = new AddressDTO("lasname","phone",15,medications,allergies);
       addressDTO.getLastName();
       addressDTO.getAge();
       addressDTO.getAllergies();
       addressDTO.getMedications();
       addressDTO.getPhone();

       AddressDTO addressDTO1 = new AddressDTO();
       addressDTO1.setLastName("lastname");
       addressDTO1.setAge(23);
       addressDTO1.setAllergies(allergies);
       addressDTO1.setMedications(medications);
       addressDTO1.setPhone("phone");

       assertNotNull(addressDTO);
       assertNotNull(addressDTO1);


    }

    @Test
    public void fireAddressDtoTest(){

        List<String> medications = List.of("medication");
        List<String> allergies = List.of("allergie");

        FireAddressDTO fireAddressDTO = new FireAddressDTO("firstname","lastname",15,medications,allergies);
        fireAddressDTO.getAge();
        fireAddressDTO.getAllergies();
        fireAddressDTO.getFirstName();
        fireAddressDTO.getLastName();
        fireAddressDTO.getMedications();

        FireAddressDTO fireAddressDTO1 = new FireAddressDTO();
        fireAddressDTO1.setAge(23);
        fireAddressDTO1.setAllergies(allergies);
        fireAddressDTO1.setFirstName("firstname");
        fireAddressDTO1.setLastName("lastname");
        fireAddressDTO1.setMedications(medications);

        assertNotNull(fireAddressDTO);
        assertNotNull(fireAddressDTO1);
    }


}

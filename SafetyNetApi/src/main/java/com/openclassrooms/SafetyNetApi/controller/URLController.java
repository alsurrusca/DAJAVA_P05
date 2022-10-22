package com.openclassrooms.SafetyNetApi.controller;


import com.openclassrooms.SafetyNetApi.dto.*;
import com.openclassrooms.SafetyNetApi.service.UrlService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class URLController {


    UrlService urlService = new UrlService();
    Logger log = LoggerFactory.getLogger(URLController.class);


    //Manque les habitants de la maison + doublon
    @GetMapping(value = "/childAlert")
    public List<ChildAlertDTO> getChildListByAddress(@RequestParam(value = "address") String address) {
        List<ChildAlertDTO> childAlertDTOS = urlService.getChildListByAddress(address);
        if (childAlertDTOS.isEmpty()) {
            log.error("Find all child by home request FAILED, address not found or no child found at this address");
        } else {
            log.info("Find all child by home request SUCCESS");
        }
        return childAlertDTOS;
    }

    //OK
    @GetMapping(value = "/personInfo")
    public List<PersonInfoDTO> getPersonInfo(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        List<PersonInfoDTO> personInfoDTOS = urlService.getPersonInfo(firstName, lastName);
        if (personInfoDTOS.isEmpty()){
            log.error("Find person info request FAILED, check firstname and lastname");
        } else {
            log.info("Find person info request SUCCESS");
        }
        return personInfoDTOS;


    }

    //OK
    @GetMapping(value = "/phoneAlert")
    public PhoneAlertDTO getPhoneAlert(@RequestParam(value = "firestation") String station) {
        PhoneAlertDTO phoneAlertDTO = urlService.getPhoneNumberFromeStation(station);
        if (phoneAlertDTO.getPhoneAlertList().isEmpty()){
            log.error("Find all phone number by firestation number request FAILED, station number not found");
        } else {
            log.info("Find all phone number by firestation number request SUCCESS");
        }
        return phoneAlertDTO;
    }

    //OK
    @GetMapping(value = "/fire")
    FirestationAdressListDTO getPersonListByStation(@RequestParam(value = "address") String address) {
        FirestationAdressListDTO firestationAdressListDTO = urlService.getPersonListByAddress(address);
        if (firestationAdressListDTO.getPersonList().isEmpty()){
            log.error("Find person by address' firestation request FAILED, address not found");
        } else {
            log.info("Find person by address' firestation request SUCCESS");
        }
        return firestationAdressListDTO;
    }

    //OK
    @GetMapping(value = "/firestation")
    public PersonListByStationDTO getPersonByListFromStation(@RequestParam(value = "stationNumber") String station) {
        PersonListByStationDTO personsByStationDTO = urlService.getPersonFromStationNumber(station);
        if (personsByStationDTO.getPersonByStation().isEmpty()) {
            log.error("Find all person by station number request FAILED");
        } else {
            log.info("Find all persons by station number request SUCCESS");
        }
        return personsByStationDTO;
    }

    //OK
    @GetMapping(value = "/communityEmail")
    public CommunityEmailDTO getEmailFromAddress(@RequestParam(value = "city") String city) {
        CommunityEmailDTO communityEmailDTO = urlService.getListFromMail(city);
        if (communityEmailDTO.getMailAlert().isEmpty()){
            log.error("Find email by city request FAILED, check the city");
        } else {
            log.info("Find email by city request SUCCESS");
        }
        return communityEmailDTO;
    }

    //OK

    @GetMapping(value = "/flood/stations")
    public List<AddressDTO> getHomeByStation(@RequestParam(value = "stations") List<String> station) {
        List<AddressDTO> addressDTOS = urlService.getHomeByStation(station);
        if (addressDTOS.isEmpty()){
            log.error("Find homes by firestation number request FAILED, station number doesn't exist");
        } else {
            log.info("Find homes by firestation number request SUCCESS");
        }
        return addressDTOS;
    }
}



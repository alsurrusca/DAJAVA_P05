package com.openclassrooms.SafetyNetApi.controller;


import com.openclassrooms.SafetyNetApi.dto.*;
import com.openclassrooms.SafetyNetApi.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class URLController {


    UrlService urlService = new UrlService();

    //Manque les habitants de la maison + doublon
    @GetMapping(value = "/childAlert")
    public List<ChildAlertDTO> getChildListByInfo(@RequestParam(value = "address") String address) {
        List<ChildAlertDTO> childAlertDTOS = urlService.getChildListByAddress(address);
        return childAlertDTOS;
    }

    //OK
    @GetMapping(value = "/personInfo")
    public List<PersonInfoDTO> getPersonInfo(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        List<PersonInfoDTO> personInfoDTOS = urlService.getPersonInfo(firstName, lastName);
        return personInfoDTOS;


    }

    //OK
    @GetMapping(value = "/phoneAlert")
    public PhoneAlertDTO getPhoneAlert(@RequestParam(value = "firestation") String station) {
        PhoneAlertDTO phoneAlertDTO = urlService.getPhoneNumberFromeStation(station);
        return phoneAlertDTO;
    }

    //Erreur 500 dès que l'on met une address
    @GetMapping(value = "/fire")
    FirestationAdressListDTO getPersonListByStation(@RequestParam(value = "address") String address) {
        FirestationAdressListDTO firestationAdressListDTO = urlService.getPersonListByAddress(address);
        return firestationAdressListDTO;
    }

    //OK
    @GetMapping(value = "/firestation")
    public PersonListByStationDTO getPersonByListFromStation(@RequestParam(value = "stationNumber") String station) {
        PersonListByStationDTO personsByStationDTO = urlService.getPersonFromStationNumber(station);
        return personsByStationDTO;
    }

    //OK
    @GetMapping(value = "/communityEmail")
    public CommunityEmailDTO getEmailFromAddress(@RequestParam(value = "city") String city) {
        CommunityEmailDTO communityEmailDTO = urlService.getListFromMail(city);
        return communityEmailDTO;
    }

    //OK

    @GetMapping(value = "/flood/stations")
    public List<AddressDTO> getHomeByStation(@RequestParam(value = "stations") String station) {
        List<AddressDTO> addressDTOS = urlService.getHomeByStation(station);
        return addressDTOS;
    }
}



package com.openclassrooms.SafetyNetApi.controller;


import com.openclassrooms.SafetyNetApi.dto.*;
import com.openclassrooms.SafetyNetApi.service.UrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class URLController {

    UrlService urlService;

    @GetMapping(value = "/?")
    public List<ChildAlertDTO> getChildListByInfo(@RequestParam(value = "address") String address) {
        List<ChildAlertDTO> childAlertDTOS = urlService.getChildListByAddress(address);
        return childAlertDTOS;
    }

    @GetMapping(value = "/?")
    public List<PersonInfoDTO> getPersonInfo(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName) {
        List<PersonInfoDTO> personInfoDTOS = urlService.getPersonInfo(firstName, lastName);
        return personInfoDTOS;


    }

    @GetMapping(value = "/?")
    public PhoneAlertDTO getPhoneAlert(@RequestParam(value = "station") String station) {
        PhoneAlertDTO phoneAlertDTO = urlService.getPhoneNumberFromeStation(station);
        return phoneAlertDTO;
    }

    @GetMapping(value = "/?")
    FirestationAdressListDTO getPersonListByStation(@RequestParam(value = "address") String address) {
        FirestationAdressListDTO firestationAdressListDTO = urlService.getPersonListByAddress(address);
        return firestationAdressListDTO;
    }

    @GetMapping(value = "/?")
    public PersonListByStationDTO getPersonByListFromStation(@RequestParam(value = "station") String station) {
        PersonListByStationDTO personsByStationDTO = urlService.getPersonFromStationNumber(station);
        return personsByStationDTO;
    }

    @GetMapping(value = "/?")
    public CommunityEmailDTO getEmailFromAddress (@RequestParam(value = "city")String city){
        CommunityEmailDTO communityEmailDTO = urlService.getListFromMail(city);
        return communityEmailDTO;
    }

    @GetMapping(value = "/?")
    public List<AddressDTO> getHomeByStation (@RequestParam(value = "station") String station){
        List<AddressDTO> addressDTOS = urlService.getHomeByStation(station);
        return addressDTOS;
    }
}



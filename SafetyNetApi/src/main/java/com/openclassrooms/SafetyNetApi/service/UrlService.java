package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.dto.*;

import java.util.List;

public class UrlService {

    UrlServiceImpl url = new UrlServiceImpl();

    public List<ChildAlertDTO> getChildListByAddress(String address) {
        return url.getChildListByAdress(address);
    }

    public List<PersonInfoDTO> getPersonInfo(String firstName, String lastname) {
        return url.getPersonListInfo(firstName, lastname);
    }


    public PhoneAlertDTO getPhoneNumberFromeStation(String station) {
        return url.getPhoneNumberListByStation(station);
    }

    public FirestationAdressListDTO getPersonListByAddress(String address) {
        return url.getPersonListByAddress(address);
    }

    public PersonListByStationDTO getPersonFromStationNumber(String station) {
        return url.getPersonFromStation(station);
    }

    public CommunityEmailDTO getListFromMail(String city) {
        return url.getCommunityEmailList(city);
    }

    public List<AddressDTO> getHomeByStation(List<String> station) {
        return url.getHomeByStationNumber(station);
    }


}

package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.dto.*;

import java.util.List;

public interface UrlRepository {


    List<ChildAlertDTO> getChildListByAdress(String address);

    List<PersonInfoDTO> getPersonListInfo(String firstName, String lastName);

    PhoneAlertDTO getPhoneNumberListByStation (String station);

    FirestationAdressListDTO getPersonListByAddress(String address);


    PersonListByStationDTO getPersonFromStation (String station);

    CommunityEmailDTO getCommunityEmailList (String city);

    List<AddressDTO> getHomeByStationNumber (String station);


}

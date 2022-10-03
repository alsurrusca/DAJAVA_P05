package com.openclassrooms.SafetyNetApi.repository;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.dto.*;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.model.Person;


import java.util.ArrayList;
import java.util.List;

public class UrlImpl implements UrlRepository {


    @Override
    //http://localhost:8080/childAlert?address=%3Caddress
    public List<ChildAlertDTO> getChildListByAdress(String address) {
        //On doit avoir une liste de personne, une liste des enfants
        List<Person> persons = new ArrayList<>();
        List<ChildAlertDTO> childList = new ArrayList<>();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();

        //On les retrouve par adresse
        persons = personRepository.getPersonByAddress(address);

        //Pour toutes les personnes à cette address, on récupère nom et prénom et âge
        for (Person person : persons) {
            for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
                if (person.getFirstName().equals(medicalRecord.getFirstName()) && person.getLastName().equals(medicalRecord.getLastName())) {
                    if (medicalRecord.getAge() <= 18) {

                        //Si tout est bon, on crée donc un objet avec nom prenom et age et on récupere l'adresse

                        ChildAlertDTO childAlertDTO = new ChildAlertDTO();
                        childAlertDTO.setFirstName(medicalRecord.getFirstName());
                        childAlertDTO.setLastName(medicalRecord.getLastName());
                        childAlertDTO.setAge(medicalRecord.getAge());
                        //childAlertDTO.getHome().add(person);

                        childList.add(childAlertDTO);

                    }

/**
 //Refaire une boucle for each si l'adresse est bonne alors on ajoute dans home tous les gens de plus de 18 ans
 for(Person person1 : persons){
 for(MedicalRecord medicalRecord1 : Data.getMedicalRecords()){
 if(person.getAddress().equals(address)){
 if(person.getLastName().equals(medicalRecord.getLastName())){
 if(medicalRecord.getAge()>18){
 ChildAlertDTO childAlertDTO = new ChildAlertDTO();

 childAlertDTO.setHome(person.getFirstName(), person.getLastName());
 childList.add(childAlertDTO);
 }
 }
 }

 }
 }
 **/
                }
            }
        }


        return childList;
    }


    //http://localhost:8080/personInfo?firstName=%3CfirstName%3E&lastName=%3ClastName
    @Override
    public List<PersonInfoDTO> getPersonListInfo(String firstName, String lastName) {

        //Avoir la liste des personnes avec les infos (nom, prénom, age, adresse, mail, allergies et médicaments)
        //address=<address>

        List<PersonInfoDTO> personInfoList = new ArrayList<>();
        List<Person> personList;
        PersonRepositoryImpl personRepositoryImpl = new PersonRepositoryImpl();
        MedicalRecordImpl medicalRecordImpl = new MedicalRecordImpl();

        //On récupère nom et prénoms
        personList = personRepositoryImpl.getPersonListByName(firstName, lastName);

        //On regarde dans personList et on récupère les infos avec medical record, on l'ajoute a la liste des infos des persons
        for (Person person : personList) {
            MedicalRecord medicalRecords = medicalRecordImpl.getByFirstName(person.getFirstName());
            personInfoList.add(new PersonInfoDTO(person.getFirstName(), person.getLastName(), medicalRecords.getAge(), person.getAddress(), person.getEmail(), medicalRecords.getMedications(), medicalRecords.getAllergies()))
            ;
        }


        return personInfoList;
    }

    @Override
    //http://localhost:8080/phoneAlert?firestation=%3Cfirestation_number
    public PhoneAlertDTO getPhoneNumberListByStation(String station) {

        //On veut une liste des numéro de téléphone avec comme paramètre les stations
        List<FireStation> fireStations;
        PhoneAlertDTO phoneAlertDTO = new PhoneAlertDTO();
        FireStationImpl fireStationImpl = new FireStationImpl();

        fireStations = fireStationImpl.getFireStationsByNumber(station);

        //On récupère les stations, les infos des personnes et si l'adresse = à l'adresse, on ajoute le numéro à phoneAlert
        for (FireStation fireStation : fireStations) {
            for (Person person : Data.getPersons()) {
                if (fireStation.getAddress().equals(person.getAddress())) {
                    phoneAlertDTO.getPhoneAlertList().add(person.getPhone());
                }
            }
        }

        return phoneAlertDTO;
    }


    @Override
    //http://localhost:8080/fire?address=7834%20Binoc%20Ave
    public FirestationAdressListDTO getPersonListByAddress(String address) {
        FirestationAdressListDTO fireAddressList = new FirestationAdressListDTO();
        List<FireStation> fireStations;
        List<Person> listPerson = new ArrayList<>();
        FireStationImpl fireStationImpl = new FireStationImpl();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();


        fireStations = fireStationImpl.getFireStationByAddress(address);


        for (FireStation fireStation : fireStations) {
            List<Person> personList1 = personRepository.getPersonByAddress(address);
            listPerson.addAll(personList1);
            String getStationFromAddress = fireStation.getStation();
            fireAddressList.setStation(getStationFromAddress);
        }
        for (Person person : listPerson) {

            MedicalRecordImpl medicalRecord = new MedicalRecordImpl();

            MedicalRecord medicalRecord1 = medicalRecord.getByFirstName(person.getFirstName());
            fireAddressList.getPersonList().add(new FireAddressDTO(person.getFirstName(), person.getLastName(), medicalRecord1.getAge(), medicalRecord1.getMedications(), medicalRecord1.getAllergies()));
        }


        return fireAddressList;
    }

    @Override
    public PersonListByStationDTO getPersonFromStation(String station) {
        //http://localhost:8080/firestation?stationNumber=<station_number>

        //List personne majeure et mineure

        PersonListByStationDTO personListByStationDTOS = new PersonListByStationDTO();
        List<FireStation> fireStations = new ArrayList<>();
        FireStationImpl fireStationImpl = new FireStationImpl();

        fireStations = fireStationImpl.getFireStationsByNumber(station);

        for (FireStation fireStation : fireStations) {
            for (Person person : Data.getPersons()) {
                if (fireStation.getAddress().equals(person.getAddress())) {
                    PersonByStationDTO personByStationDTO = new PersonByStationDTO();


                    //On ajoute les noms adresse et phone
                    personByStationDTO.setFirstName(person.getFirstName());
                    personByStationDTO.setLastName(person.getLastName());
                    personByStationDTO.setAddress(person.getAddress());
                    personByStationDTO.setPhone(person.getPhone());


                    personListByStationDTOS.getPersonByStation().add(personByStationDTO);

                    //On crée une liste de personne mineur et majeur
                    for (MedicalRecord medicalRecord : Data.getMedicalRecords()) {
                        if (medicalRecord.getFirstName().equals(personByStationDTO.getFirstName())) {
                            if (medicalRecord.getAge() > 18) {
                                personListByStationDTOS.setMajeur(personListByStationDTOS.getMajeur() + 1);
                            } else {
                                personListByStationDTOS.setMineur(personListByStationDTOS.getMineur() + 1);
                            }
                        }
                    }
                }
            }
        }
        return personListByStationDTOS;
    }

    @Override
    //http://localhost:8080/communityEmail?city=<city>
    public CommunityEmailDTO getCommunityEmailList(String city) {

        //List des Emails

        CommunityEmailDTO communityEmailDTO = new CommunityEmailDTO();

        for (Person person : Data.getPersons()) {
            if (person.getCity().equals(city)) {
                communityEmailDTO.getMailAlert().add(person.getEmail());
            }
        }
        return communityEmailDTO;
    }


    @Override
    //http://localhost:8080/flood/stations?stations=%3Ca


    public List<AddressDTO> getHomeByStationNumber(List<String> station) {

        //List des firestations en fonction des maisons

        List<FirestationStationNumberDTO> firestationStationNumberDTOS = new ArrayList<>();
        List<AddressDTO> addressDTOS = new ArrayList<>();
        List<FireStation> fireStations = new ArrayList<>();
        FireStationImpl fireStationImpl = new FireStationImpl();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        MedicalRecordImpl medicalRecordImpl = new MedicalRecordImpl();
        List<Person> personList = new ArrayList<>();

        fireStations = fireStationImpl.getFireStationsByNumber(station);

        for (FireStation fireStation : fireStations) {
            List<Person> personList1 = personRepository.getPersonByAddress(fireStation.getAddress());
            personList.addAll(personList1);
        }

        for (Person person : personList) {
            MedicalRecord medicalRecord = medicalRecordImpl.getByFirstName(person.getFirstName());
            medicalRecords.add(medicalRecord);

            addressDTOS.add(new AddressDTO(person.getLastName(), person.getPhone(), medicalRecord.getAge(), medicalRecord.getMedications(), medicalRecord.getAllergies()));
        }


        return addressDTOS;
    }
}

package com.openclassrooms.SafetyNetApi.service;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.dto.*;
import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.model.Person;
import com.openclassrooms.SafetyNetApi.repository.FireStationRepository;
import com.openclassrooms.SafetyNetApi.repository.MedicalRecordRepository;
import com.openclassrooms.SafetyNetApi.repository.PersonRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class UrlService {



    //http://localhost:8080/childAlert?address=%3Caddress
    public List<ChildAlertDTO> getChildListByAdress(String address) {
        //On doit avoir une liste de personne, une liste des enfants
        List<Person> persons = new ArrayList<>();
        List<ChildAlertDTO> childList = new ArrayList<>();
        PersonRepository personRepository = new PersonRepository();
        MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

        //On les retrouve par adresse
        persons = personRepository.getPersonByAddress(address);

        //Pour toutes les personnes à cette address, on récupère nom et prénom et âge
        for (Person person : persons) {
            for (MedicalRecord medicalRecord : medicalRecordRepository.findAll()) {
                if (person.getFirstName().equals(medicalRecord.getFirstName()) && person.getLastName().equals(medicalRecord.getLastName())) {
                    if (medicalRecord.getAge() <= 18) {

                        //Si tout est bon, on crée donc un objet avec nom prenom et age et on récupere l'adresse

                        ChildAlertDTO childAlertDTO = new ChildAlertDTO();
                        childAlertDTO.setFirstName(medicalRecord.getFirstName());
                        childAlertDTO.setLastName(medicalRecord.getLastName());
                        childAlertDTO.setAge(medicalRecord.getAge());

                        childList.add(childAlertDTO);


                        //Refaire une boucle for each si l'adresse est bonne alors on ajoute dans home tous les gens de plus de 18 ans
                        for (Person person1 : persons) {
                            for (MedicalRecord medicalRecord1 : medicalRecordRepository.findAll()) {
                                if (person1.getAddress().equals(address)) {
                                    if (person1.getLastName().equals(medicalRecord1.getLastName()) && person1.getFirstName().equals(medicalRecord1.getFirstName())) {
                                        if (person1.getLastName().equals(childAlertDTO.getLastName())) {

                                            if (medicalRecord1.getAge() > 18) {

                                                childAlertDTO.getHome().add(new ListHome(person1.getFirstName(), person1.getLastName()));
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }


        return childList;
    }


    //http://localhost:8080/personInfo?firstName=%3CfirstName%3E&lastName=%3ClastName

    public List<PersonInfoDTO> getPersonListInfo(String firstName, String lastName) {

        //Avoir la liste des personnes avec les infos (nom, prénom, age, adresse, mail, allergies et médicaments)
        //address=<address>

        List<PersonInfoDTO> personInfoList = new ArrayList<>();
        List<Person> personList;
        PersonRepository personRepositoryImpl = new PersonRepository();
        MedicalRecordRepository medicalRecordImpl = new MedicalRecordRepository();

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


    //http://localhost:8080/phoneAlert?firestation=%3Cfirestation_number
    public PhoneAlertDTO getPhoneNumberListByStation(String station) {

        //On veut une liste des numéro de téléphone avec comme paramètre les stations
        List<FireStation> fireStations;
        PhoneAlertDTO phoneAlertDTO = new PhoneAlertDTO();
        FireStationRepository fireStationImpl = new FireStationRepository();
        PersonRepository personRepository = new PersonRepository();

        fireStations = fireStationImpl.getFireStationByNumber(station);

        //On récupère les stations, les infos des personnes et si l'adresse = à l'adresse, on ajoute le numéro à phoneAlert
        for (FireStation fireStation : fireStations) {
            for (Person person : personRepository.findAll()) {
                if (fireStation.getAddress().equals(person.getAddress())) {
                    phoneAlertDTO.getPhoneAlertList().add(person.getPhone());
                }
            }
        }

        return phoneAlertDTO;
    }


    //http://localhost:8080/fire?address=7834%20Binoc%20Ave
    public FirestationAdressListDTO getPersonListByAddress(String address) {
        FirestationAdressListDTO fireAddressList = new FirestationAdressListDTO();
        List<FireStation> fireStations;
        List<Person> listPerson = new ArrayList<>();
        FireStationRepository fireStationImpl = new FireStationRepository();
        PersonRepository personRepository = new PersonRepository();


        fireStations = fireStationImpl.getFireStationByAddress(address);


        for (FireStation fireStation : fireStations) {
            List<Person> personList1 = personRepository.getPersonByAddress(address);
            listPerson.addAll(personList1);
            String getStationFromAddress = fireStation.getStation();
            fireAddressList.setStation(getStationFromAddress);
        }
        for (Person person : listPerson) {

            MedicalRecordRepository medicalRecord = new MedicalRecordRepository();

            MedicalRecord medicalRecord1 = medicalRecord.getByFirstName(person.getFirstName());
            fireAddressList.getPersonList().add(new FireAddressDTO(person.getFirstName(), person.getLastName(), medicalRecord1.getAge(), medicalRecord1.getMedications(), medicalRecord1.getAllergies()));
        }


        return fireAddressList;
    }

    public PersonListByStationDTO getPersonFromStation(String station) {
        //http://localhost:8080/firestation?stationNumber=<station_number>

        //List personne majeure et mineure

        PersonListByStationDTO personListByStationDTOS = new PersonListByStationDTO();
        List<FireStation> fireStations = new ArrayList<>();
        FireStationRepository fireStationImpl = new FireStationRepository();
        PersonRepository personRepository = new PersonRepository();

        fireStations = fireStationImpl.getFireStationByNumber(station);

        for (FireStation fireStation : fireStations) {
            for (Person person : personRepository.findAll()) {
                if (fireStation.getAddress().equals(person.getAddress())) {
                    PersonByStationDTO personByStationDTO = new PersonByStationDTO();
                    MedicalRecordRepository medicalRecordRepository = new MedicalRecordRepository();

                    //On ajoute les noms adresse et phone
                    personByStationDTO.setFirstName(person.getFirstName());
                    personByStationDTO.setLastName(person.getLastName());
                    personByStationDTO.setAddress(person.getAddress());
                    personByStationDTO.setPhone(person.getPhone());


                    personListByStationDTOS.getPersonByStation().add(personByStationDTO);

                    //On crée une liste de personne mineur et majeur
                    for (MedicalRecord medicalRecord : medicalRecordRepository.findAll() ) {

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


    //http://localhost:8080/communityEmail?city=<city>
    public CommunityEmailDTO getCommunityEmailList(String city) {

        //List des Emails

        CommunityEmailDTO communityEmailDTO = new CommunityEmailDTO();
        PersonRepository personRepository = new PersonRepository();

        for (Person person : personRepository.findAll()) {
            if (person.getCity().equals(city)) {
                communityEmailDTO.getMailAlert().add(person.getEmail());
            }
        }
        return communityEmailDTO;
    }



    //http://localhost:8080/flood/stations?stations=%3Ca


    public List<AddressDTO> getHomeByStationNumber(List<String> station) {

        //List des firestations en fonction des maisons

        List<AddressDTO> addressDTOS = new ArrayList<>();
        List<FireStation> fireStations = new ArrayList<>();
        FireStationRepository fireStationImpl = new FireStationRepository();
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = new ArrayList<>();

        fireStations = fireStationImpl.getFireStationsByNumber(station);

        for (FireStation fireStation : fireStations) {

            List<Person> personList1 = personRepository.getPersonByAddress(fireStation.getAddress());
            personList.addAll(personList1);

        }
        MedicalRecordRepository medicalRecordImpl = new MedicalRecordRepository();
        List<MedicalRecord> medicalRecords = new ArrayList<>();

        for (Person person : personList) {
            MedicalRecord medicalRecord = medicalRecordImpl.getByFirstName(person.getFirstName());
            medicalRecords.add(medicalRecord);
            addressDTOS.add(new AddressDTO(person.getLastName(), person.getPhone(), medicalRecord.getAge(), medicalRecord.getMedications(), medicalRecord.getAllergies()));
        }


        return addressDTOS;
    }
}

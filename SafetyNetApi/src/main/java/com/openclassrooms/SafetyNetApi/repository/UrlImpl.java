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
    public List<ChildAlertDTO> getChildListByAdress(String address) {
        //On doit avoir une liste de personne, une liste des enfants
        List<Person> persons = new ArrayList<>();
        List<ChildAlertDTO> childList = new ArrayList<>();
        PersonRepositoryImpl getListAddress = new PersonRepositoryImpl();

        //On les retrouve par adresse
        persons = getListAddress.getPersonByAddress(address);

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
                        childAlertDTO.getHome().add(person);


                    }
                }
            }
        }
        return childList;
    }

    @Override
    public List<PersonInfoDTO> getPersonListInfo(String firstName, String lastName) {

        //Avoir la liste des personnes avec les infos (nom, prénom, age, adresse, mail, allergies et médicaments)

        List<PersonInfoDTO> personInfoList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        PersonRepositoryImpl personRepositoryImpl = new PersonRepositoryImpl();
        MedicalRecordImpl medicalRecordImpl = new MedicalRecordImpl();

        //On récupère nom et prénoms
        personList = personRepositoryImpl.getPersonByName(firstName, lastName);

        //On regarde dans personList et on récupère les infos avec medical record, on l'ajoute a la liste des infos des persons
        for (Person person : personList) {
            MedicalRecord medicalRecords = medicalRecordImpl.getByFirstName(person.getFirstName());
            personInfoList.add(person.getFirstName(), person.getLastName(), medicalRecords.getAge(), person.getAddress(), person.getEmail(), medicalRecords.getMedications(), medicalRecords.getAllergies()))
            ;
        }

        return personInfoList;
    }

    @Override
    public PhoneAlertDTO getPhoneNumberListByStation(String station) {

        //On veut une liste des numéro de téléphone avec comme paramètre les stations
        List<FireStation> fireStations = new ArrayList<>();
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
    public FirestationAdressListDTO getPersonListByAddress(String address) {

        //On veut une liste des gens par adresse

        List<FireStation> fireStations = new ArrayList<>();
        FirestationAdressListDTO firestationAdressListDTO = new FirestationAdressListDTO();
        FireStationImpl fireStationImpl = new FireStationImpl();
        List<Person> personList = new ArrayList<>();
        PersonRepositoryImpl personRepository = new PersonRepositoryImpl();

        MedicalRecordImpl medicalRecordImpl = new MedicalRecordImpl();

        fireStations = fireStationImpl.getFireStationByAddress(address);

        List<FireStation> firestationNumber = fireStationImpl.getFireStationByAddress(address);
        firestationAdressListDTO.setFirestation(firestationNumber);

        for (FireStation fireStation : fireStations) {
            List<Person> personList1 = personRepository.getPersonByAddress(fireStation.getAddress());
            personList.addAll(personList1);
        }

        //On ajoute à la liste les noms, prénoms, age, medicaments et allergies

        for (Person person : personList){
            MedicalRecord medicalRecord = medicalRecordImpl.getByFirstName(person.getFirstName());
            firestationAdressListDTO.getFirestationList().add(person.getFirstName(), person.getLastName(), medicalRecord.getAge(), medicalRecord.getMedications(), medicalRecord.getAllergies());
        }
            return firestationAdressListDTO;
    }


    @Override
    public PersonListByStationDTO getPersonFromStation(String station) {

        //List personne majeure et mineure

        PersonListByStationDTO personListByStationDTOS = new ArrayList<>();
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

                    personListByStationDTOS.getPersonByStation().add(personByStationDTO)

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
    public List<AddressDTO> getHomeByStationNumber(String station) {

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

        for(FireStation fireStation : fireStations){
            List<Person> personList1 = personRepository.getPersonByAddress(fireStation.getAddress());
            personList.addAll(personList1);
        }

        for(Person person : personList){
            MedicalRecord medicalRecord = medicalRecordImpl.getByFirstName(person.getFirstName());
            medicalRecords.add(medicalRecord);

            addressDTOS.add(person.getLastName(), person.getPhone(), medicalRecord.getAge(), medicalRecord.getMedications(), medicalRecord.getAllergies()));
        }


        return addressDTOS;
    }
}

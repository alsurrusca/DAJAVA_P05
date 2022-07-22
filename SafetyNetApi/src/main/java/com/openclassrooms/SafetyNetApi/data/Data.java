package com.openclassrooms.SafetyNetApi.data;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class Data {


    public static List<Person> persons = new ArrayList<Person>();
    private static List<FireStation> fireStations = new ArrayList<FireStation>();
    private static List<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();



    public static List<Person> getPersons() {
        return persons;
    }

    public  void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public static List<FireStation> getFireStations() {
        return fireStations;
    }

    public  void setFireStations(List<FireStation> fireStations) {
        this.fireStations = fireStations;
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public  void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }


    @Override
    public String toString() {
        return "{" +
                "persons=" + persons +
                ", medicalRecords=" + medicalRecords +
                ", fireStations=" + fireStations +
                '}';
    }
}

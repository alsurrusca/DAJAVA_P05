package com.openclassrooms.SafetyNetApi.data;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.model.Person;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Data {


    public static List<Person> persons = new ArrayList<Person>();
    public static List<FireStation> firestations = new ArrayList<FireStation>();
    public static List<MedicalRecord> medicalrecords = new ArrayList<MedicalRecord>();



    public static List<Person> getPersons() {
        return persons;
    }

    public  void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public static List<FireStation> getFireStations() {
        return firestations;
    }

    public  void setFireStations(List<FireStation> firestations) {
        this.firestations = firestations;
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalrecords;
    }

    public  void setMedicalRecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }


    @Override
    public String toString() {
        return "{" +
                "persons=" + persons +
                ", medicalRecords=" + medicalrecords +
                ", fireStations=" + firestations +
                '}';
    }
}

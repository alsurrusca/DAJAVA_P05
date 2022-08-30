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
    private static List<Person> persons = new ArrayList<Person>();
    private static List<MedicalRecord> medicalrecords= new ArrayList<MedicalRecord>();
    private static List<FireStation> firestations= new ArrayList<FireStation>();


    public static List<Person> getPersons() {
        return persons;
    }

    public static List<FireStation> getFireStations() {
        return firestations;
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalrecords;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void setMedicalrecords(List<MedicalRecord> medicalrecords) {
        this.medicalrecords = medicalrecords;
    }

    public void setFirestations(List<FireStation> firestations) {
        this.firestations = firestations;
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

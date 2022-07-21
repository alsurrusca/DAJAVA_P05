package com.openclassrooms.SafetyNetApi.data;

import com.openclassrooms.SafetyNetApi.model.FireStation;
import com.openclassrooms.SafetyNetApi.model.MedicalRecord;
import com.openclassrooms.SafetyNetApi.model.Person;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Data {


    public static List<Person> persons = new ArrayList<Person>();
    private static List<FireStation> fireStations = new ArrayList<FireStation>();
    private static List<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();



    public static List<Person> getPersons() {
        return persons;
    }

    public static void setPersons(List<Person> persons) {
        Data.persons = persons;
    }

    public static List<FireStation> getFireStations() {
        return fireStations;
    }

    public static void setFireStations(List<FireStation> fireStations) {
        Data.fireStations = fireStations;
    }

    public static List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public static void setMedicalRecords(List<MedicalRecord> medicalRecords) {
        Data.medicalRecords = medicalRecords;
    }


}

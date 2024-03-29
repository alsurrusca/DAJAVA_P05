package com.openclassrooms.SafetyNetApi.dto;

import java.util.ArrayList;
import java.util.List;

public class PersonListByStationDTO {

    private List<PersonByStationDTO> personByStation = new ArrayList<>();
    private int mineur;
    private int majeur;

    public List<PersonByStationDTO> getPersonByStation() {
        return personByStation;
    }

    public int getMineur() {
        return mineur;
    }

    public void setMineur(int mineur) {
        this.mineur = mineur;
    }

    public int getMajeur() {
        return majeur;
    }

    public void setMajeur(int majeur) {
        this.majeur = majeur;
    }
}

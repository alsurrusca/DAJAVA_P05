package com.openclassrooms.SafetyNetApi.dto;

import java.util.ArrayList;
import java.util.List;

public class CommunityEmailDTO {

    private List<String> mailAlert = new ArrayList<>();

    public List<String> getMailAlert() {
        return mailAlert;
    }

    public void setMailAlert(List<String> mailAlert) {
        this.mailAlert = mailAlert;
    }
}

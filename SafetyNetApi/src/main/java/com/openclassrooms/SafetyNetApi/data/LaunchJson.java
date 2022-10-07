package com.openclassrooms.SafetyNetApi.data;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class LaunchJson {


    public void launchJson() {



        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            File file = new File("src/main/resources/data.json");
            Data data = mapper.readValue( file, Data.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


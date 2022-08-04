package com.openclassrooms.SafetyNetApi.data;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;


public class LaunchJson {


    public void launchJson() {



        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            File file = new File("src/main/resources/data.json");
            Data data = mapper.readValue( file, Data.class);
            System.out.println(Data.persons.toString());
            System.out.println(Data.medicalrecords.toString());
            System.out.println(Data.firestations.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


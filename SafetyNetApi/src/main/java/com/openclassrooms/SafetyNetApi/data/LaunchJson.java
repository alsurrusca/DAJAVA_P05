package com.openclassrooms.SafetyNetApi.data;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;

@Configuration
public class LaunchJson {


    public void launchJson() {



        try {
            ObjectMapper mapper = new ObjectMapper();

            File file = new File("src/main/resources/data.json");
            Data data = mapper.readValue( file, Data.class);
            System.out.println(Data.persons);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


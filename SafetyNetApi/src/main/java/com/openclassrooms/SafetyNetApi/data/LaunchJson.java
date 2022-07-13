package com.openclassrooms.SafetyNetApi.data;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LaunchJson {


    public void launchJson() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode neoJsonNode = mapper.readTree("src/main/resources/data.json");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}


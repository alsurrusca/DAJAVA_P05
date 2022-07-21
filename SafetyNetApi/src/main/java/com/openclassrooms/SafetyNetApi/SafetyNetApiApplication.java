package com.openclassrooms.SafetyNetApi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.data.LaunchJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.openclassrooms.SafetyNetApi.repository"})
public class SafetyNetApiApplication {


    public static void main(String[] args) {
        LaunchJson launchJson = new LaunchJson();
        launchJson.launchJson();
        SpringApplication.run(SafetyNetApiApplication.class, args);
        System.out.println(Data.persons.toString());
    }



}





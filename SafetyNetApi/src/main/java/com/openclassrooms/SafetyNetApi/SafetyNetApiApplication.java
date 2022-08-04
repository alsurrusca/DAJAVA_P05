package com.openclassrooms.SafetyNetApi;


import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.data.LaunchJson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SafetyNetApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(SafetyNetApiApplication.class, args);
        LaunchJson launchJson = new LaunchJson();
        launchJson.launchJson();


    }



}





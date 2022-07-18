package com.openclassrooms.SafetyNetApi;

import com.openclassrooms.SafetyNetApi.data.Data;
import com.openclassrooms.SafetyNetApi.data.LaunchJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SafetyNetApiApplication implements CommandLineRunner  {


    public static void main(String[] args) {
        LaunchJson launchJson = new LaunchJson();
        launchJson.launchJson();
        SpringApplication.run(SafetyNetApiApplication.class, args);
        System.out.println(Data.persons);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}





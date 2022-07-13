package com.openclassrooms.SafetyNetApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SafetyNetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SafetyNetApiApplication.class, args);
	}

}

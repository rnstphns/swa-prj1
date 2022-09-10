package edu.miu.swa.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SwaProject1Application.class, args);
	}
//TODO figure out where to put the CSV file in application.properties
	// for tomorrow me: looks like they defined the jar in Dockerfile and defined the springboot-docker-container
	//in docker-compose.yml ... check it out over there --->
}

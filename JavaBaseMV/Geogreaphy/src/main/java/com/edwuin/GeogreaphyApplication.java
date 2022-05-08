package com.edwuin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GeogreaphyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeogreaphyApplication.class, args);
	}

}

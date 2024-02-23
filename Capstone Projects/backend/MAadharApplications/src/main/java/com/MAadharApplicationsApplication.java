package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.entity")
@EnableJpaRepositories(basePackages = "com.repository")
public class MAadharApplicationsApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SpringApplication.run(MAadharApplicationsApplication.class, args);
		System.err.println("Spring Boot MAadhar Card Service Up On Port Number 9090");
	}

}

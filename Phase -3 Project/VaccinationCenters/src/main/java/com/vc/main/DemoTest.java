package com.vc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages = "com.vc.entity")  		// enable @Entity class. 
@EnableJpaRepositories(basePackages = "com.vc.repository")// it is use to enable spring jpa data features
public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DemoTest.class, args);
		System.out.println("Spring boot Is Up");
		
	}

}

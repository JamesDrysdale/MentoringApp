package com.codeclan.mentoring.mentoringservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.codeclan.mentoring.mentoringservice"})
public class MentoringserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MentoringserviceApplication.class, args);
	}

}

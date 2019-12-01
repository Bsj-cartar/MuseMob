package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MuseMobApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuseMobApplication.class, args);
	}

	
}

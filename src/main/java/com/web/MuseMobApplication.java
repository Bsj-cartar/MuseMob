package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync


@SpringBootApplication 
public class MuseMobApplication extends SpringBootServletInitializer {
	public static void main(String[] args) { 
		SpringApplication.run(MuseMobApplication.class, args); } 
	
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
		return builder.sources(MuseMobApplication.class); } 
	}


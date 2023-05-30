package com.cg.ata.project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AutomationtravelAgencyApplication {

	private static final Logger LOG = LoggerFactory.getLogger(AutomationtravelAgencyApplication.class);
	
	public static void main(String[] args) {
		
		
		SpringApplication.run(AutomationtravelAgencyApplication.class, args);
		LOG.info("******Aplication Started...!******");
	}

}

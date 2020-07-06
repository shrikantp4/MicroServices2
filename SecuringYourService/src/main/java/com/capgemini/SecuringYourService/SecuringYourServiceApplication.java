package com.capgemini.SecuringYourService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SecuringYourServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuringYourServiceApplication.class, args);
	}

}

package com.capgemini.configurationServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigurationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationServerApplication.class, args);
	}

	/*
	localhost:8080/s1rates/default
	
	localhost:8080/s1100/master -------still looks default
	add search-paths - station*
	now it can search from subfolders also
	localhost:8080/s1rates/dev
	localhost:8080/s2rates/qa
	localhost:8080/s1rates-default.properties
	localhost:8080/s1rates-default.yml
	localhost:8080/s1rates-default.json
	*/
}

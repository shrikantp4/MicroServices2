package com.capgemini.HystrixDemo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.capgemini.HystrixDemo.beans.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class PersonController {
	
	@Autowired
	private RestTemplate restTemplate;

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	
	@HystrixCommand(fallbackMethod="getDefaultPerson")
	@RequestMapping(path="/persondetails", params={"personid"})
	public String getPersonDetails(@RequestParam String personid, Model m){
		System.out.println("getPersonDetails called!");
		Person p = restTemplate.getForObject("http://person-produce-service/person/" + personid, Person.class);
		m.addAttribute("person", p);

		return "console";
	}
	
	public String getDefaultPerson(@RequestParam String personid, Model m){
		System.out.println("Fallback operation called!");
		m.addAttribute("person", new Person(404, "", ""));
		return "console";
	} 
	
	@RequestMapping("/")
	public @ResponseBody String hello(){
		return "hello";
	}

}

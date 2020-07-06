package com.capgemini.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Person;

@RestController
public class PersonController {

	@RequestMapping("/person/{id}")
	  public Person getPerson(@PathVariable int id){

	  	switch(id){
	  	case 1: return new Person(1, "Shrikant", "Patro");
	  	case 2: return new Person(2, "Swami", "Rao");
	  	case 3: return new Person(3, "Sameer", "Das");
	  	}
	  	return null;
	  }
}

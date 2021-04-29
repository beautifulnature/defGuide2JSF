package com.example.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.example.project.model.Person;

@Stateless
public class PersonService {
	
	List<Person> persons = new ArrayList<>();
	
	public PersonService() {
		Person person1 = new Person(1L, "nagaraju", "nag@email.com");
		Person person2 = new Person(2L, "gumpini", "gumpini@email.com");
		Person person3 = new Person(3L, "gnr", "gnr@email.com");
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
	}

	public List<Person> getAll() {
		return persons;
	}
}
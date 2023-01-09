package com.masai.app.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.masai.app.Gym;
import com.masai.app.Person;

@Configuration
@ComponentScan(basePackages = { "com.masai.app" })
public class MyConfig {

	@Bean("personList")
	public List<Person> persons() {

		Person p1 = new Person(1, "mahipat", "abc@123", 23, "7089726372");
		Person p2 = new Person(2, "mahi", "ajc@123", 23, "9989726372");
		Person p3 = new Person(3, "pat", "acd@123", 21, "8089726372");
		Person p4 = new Person(4, "parmar", "asabc@123", 33, "6589726372");
		Person p5 = new Person(5, "sagar", "ajsdwc@123", 30, "1989726372");

		List<Person> pList = new ArrayList<>();
		pList.add(p5);
		pList.add(p4);
		pList.add(p3);
		pList.add(p2);
		pList.add(p1);

		return pList;

	}

//	inject 3 entries with valid details 

	@Bean("mapData")
	public Map<Person, Gym> mapDate() {

		Person p1 = new Person(1, "mahipat", "abc@123", 23, "7089726372");
		Person p2 = new Person(2, "mahi", "ajc@123", 23, "9989726372");
		Person p3 = new Person(3, "pat", "acd@123", 21, "8089726372");

		Gym g1 = new Gym(1, "strong", 1200);
		Gym g2 = new Gym(2, "iron", 1400);
		Gym g3 = new Gym(3, "hulk", 2000);

		Map<Person, Gym> map = new HashMap<>();

		map.put(p3, g3);
		map.put(p2, g2);
		map.put(p1, g1);

		return map;

	}
}

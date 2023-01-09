package com.masai.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("person")
@PropertySource("App.properties")
public class PersonService {

	@Autowired
	@Qualifier("mapData")
	private Map<Person, Gym> theMap; // inject 3 entries with valid details 

	@Autowired
	@Qualifier("personList")
	private List<Person> theList; // inject List of 5 Person object

	@Value("${AppName}")
	private String appName;

	public void printMap() {

		// print all the person's and their gym details from the Map
		for (Map.Entry<Person, Gym> entry : theMap.entrySet()) {

			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}

	}

	public void printList() {

		// sort the List of Person according to the increasing order of the age
		// print all the sorted Person Details

		theList.stream().sorted((a, b) -> a.getAge() - b.getAge()).forEach(System.out::println);
	}

	public void printAppName() {

		// print the injected appName
		System.out.println(this.appName);

	}

}

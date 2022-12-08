package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class Demo2 {

	private List<String> cities;

	@Autowired
	private Environment env;

	public void print() {
		cities = new ArrayList<String>();
		cities.add(env.getProperty("city.c1"));
		cities.add(env.getProperty("city.c2"));
		cities.add(env.getProperty("city.c3"));
		cities.add(env.getProperty("city.c4"));
		cities.add(env.getProperty("city.c5"));

		System.out.println(cities);

	}

}

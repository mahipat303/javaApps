package com.masai;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Demo1 {

	@Autowired
	@Qualifier("cities")
	private List<String> cities;

	public void print() {
		for (String city : cities) {
			System.out.println(city);
		}
	}

}

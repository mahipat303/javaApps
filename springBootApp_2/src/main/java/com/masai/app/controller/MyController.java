package com.masai.app.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.masai.model.Employee;

@Controller(value = "mycontroler")
public class MyController {

	@RequestMapping("/hello")
	@ResponseBody
	public String sayHello() {
		return "Welcome to Spring boot";
	}

	@RequestMapping("/employee")
	@ResponseBody
	public Employee generateEmployee() {

		Employee e = new Employee(1, "ram", "talala", 100000);

		return e;
	}

	@RequestMapping("/employees")
	@ResponseBody
	public List<Employee> generateEmployeeList() {

		return Arrays.asList(new Employee(1, "ram", "talala", 100000), new Employee(2, "shyam", "veraval", 200000),
				new Employee(3, "raja", "rajkot", 100021), new Employee(4, "akbar", "delhi", 150000),
				new Employee(5, "mahi", "talala", 233990));

	}

}

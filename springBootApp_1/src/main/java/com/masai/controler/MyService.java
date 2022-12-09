package com.masai.controler;

import org.springframework.stereotype.Controller;

@Controller(value = "myservice")
public class MyService {

	public void sayHello(String name) {
		System.out.println("Welcome " + name);
	}

}

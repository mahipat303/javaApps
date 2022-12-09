package com.masai.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.masai.controler.MyService;

@SpringBootApplication
@ComponentScan(value = "com.masai.controler")
public class SpringBootApp1Application {

	public static void main(String[] args) {

		ApplicationContext cntx = SpringApplication.run(SpringBootApp1Application.class, args);

		MyService ms = cntx.getBean("myservice", MyService.class);

		ms.sayHello("Mahipat");

	}

}

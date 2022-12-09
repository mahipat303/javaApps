package com.masai.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.masai.app.controller.MyController;

@SpringBootApplication
public class SpringBootApp2Application {

	public static void main(String[] args) {
		ApplicationContext cntx = SpringApplication.run(SpringBootApp2Application.class, args);

		MyController mc = cntx.getBean("mycontroler", MyController.class);

		mc.sayHello();

		mc.generateEmployee();

		mc.generateEmployeeList();

	}

}

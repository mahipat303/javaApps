package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {

		ApplicationContext cntx = new ClassPathXmlApplicationContext("Beans.xml");

		Collage clg = cntx.getBean("collage", Collage.class);

		clg.showDetails();

	}

}

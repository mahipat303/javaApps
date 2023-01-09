package com.masai.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.masai.app.config.MyConfig;

public class Demo {

	public static void main(String[] args) {

		ApplicationContext cntx = new AnnotationConfigApplicationContext(MyConfig.class);

		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) cntx;

		PersonService ps = cntx.getBean("person", PersonService.class);

		ps.printMap();
		ps.printList();
		ps.printAppName();

		ctx.close();

	}

}

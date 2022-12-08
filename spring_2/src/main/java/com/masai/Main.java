package com.masai;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext cntx = new AnnotationConfigApplicationContext(Myconfig.class);

		AnnotationConfigApplicationContext ctx = (AnnotationConfigApplicationContext) cntx;

		// by the help of Bean annotation...

		Demo1 d1 = cntx.getBean("demo1", Demo1.class);

		d1.print();

		// by the help of properties file...

		Demo2 d2 = cntx.getBean("demo2", Demo2.class);

		d2.print();

		ctx.close();

	}

}

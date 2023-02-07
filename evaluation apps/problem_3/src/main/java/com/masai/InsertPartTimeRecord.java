package com.masai;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsertPartTimeRecord {
	public static void main(String[] args) {

		PartTimeInstructor f1 = new PartTimeInstructor("mark", 30, 2000, "123456");
		PartTimeInstructor f2 = new PartTimeInstructor("zerk", 20, 2000, "344456");
		PartTimeInstructor f3 = new PartTimeInstructor("tom", 10, 200, "23456");
		PartTimeInstructor f4 = new PartTimeInstructor("rohit", 30, 2000, "1234346");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(f1);
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);

		em.getTransaction().commit();
		
		em.close();

	}
}

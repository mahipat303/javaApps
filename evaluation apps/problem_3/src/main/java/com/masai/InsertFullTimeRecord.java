package com.masai;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsertFullTimeRecord {

	public static void main(String[] args) {

		FullTimeInstructor f1 = new FullTimeInstructor("ram", 100000, "ram@123");
		FullTimeInstructor f2 = new FullTimeInstructor("hari", 10000, "hari@123");
		FullTimeInstructor f3 = new FullTimeInstructor("mahi", 104000, "mahi@123");
		FullTimeInstructor f4 = new FullTimeInstructor("sagar", 100000, "sagar@123");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(f1);
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);

		em.getTransaction().commit();

	}

}

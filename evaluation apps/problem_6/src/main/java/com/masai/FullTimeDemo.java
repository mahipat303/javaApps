package com.masai;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FullTimeDemo {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		Query q = em.createNamedQuery("getFullTime");

		q.setParameter("type", 1);

		List<Instructor> flist = (List<Instructor>) q.getResultList();

		for (Instructor fullTimeInstructor : flist) {
			System.out.println(fullTimeInstructor);
		}

		em.close();

	}

}

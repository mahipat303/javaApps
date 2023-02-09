package com.masai;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetFullTimeById {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter id :- ");
		int id = sc.nextInt();

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		Query q = em.createNamedQuery("getById");

		q.setParameter("type", id);

		FullTimeInstructor f = (FullTimeInstructor) q.getSingleResult();

		System.out.println(f);

		em.close();

	}

}

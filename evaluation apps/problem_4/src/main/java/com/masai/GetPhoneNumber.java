package com.masai;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetPhoneNumber {

	public static User find(String name) throws UserException {
		User u = null;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		Query q = em.createNamedQuery("getUserByname");
		q.setParameter("name", name);

		try {
			u = (User) q.getSingleResult();
		} catch (Exception e) {
			throw new UserException("User Not Found Exception");
		}

		return u;
	}

	public static void main(String[] args) {

		User u = null;
		try {
			u = find("Nrupul");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<PhoneNumber> pho = u.getPhones();

		for (PhoneNumber phoneNumber : pho) {
			System.out.println(pho);
		}

		User u2 = null;
		try {
			u2 = find("Albert");
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<PhoneNumber> pho1 = u2.getPhones();

		for (PhoneNumber phoneNumber : pho1) {
			System.out.println(pho);
		}

	}

}

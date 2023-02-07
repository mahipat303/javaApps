package com.masai;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateRecord2 {
	public static void main(String[] args) {

		User user = new User();
		user.setUserName("Nrupul");
		user.setEmailid("abc@123");
		user.setUserId(1);

		PhoneNumber ph = new PhoneNumber();
		ph.setPhoneNumber("13434");
		ph.setPhoneType(PhoneType.Home);

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setPhoneNumber("243433");
		ph.setPhoneType(PhoneType.office);

		PhoneNumber ph3 = new PhoneNumber();
		ph2.setPhoneNumber("343433");
		ph.setPhoneType(PhoneType.Landline);

		user.getPhones().add(ph2);
		user.getPhones().add(ph);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(user);

		em.getTransaction().commit();

		em.close();
	}
}

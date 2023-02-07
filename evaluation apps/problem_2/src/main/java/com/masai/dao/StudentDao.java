package com.masai.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.masai.exception.CourseException;
import com.masai.exception.StudentException;
import com.masai.model.Course;
import com.masai.model.Student;

public class StudentDao {

	public void addCourse(Course course) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(course);

		em.getTransaction().commit();

	}

	public void getStudent(int roll_no) throws StudentException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		Student st = em.find(Student.class, roll_no);

		if (st == null) {
			throw new StudentException("student not found...");
		}

		System.out.println(st.toString());

	}

	public void getCourse(int course_id) throws CourseException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Student");

		EntityManager em = emf.createEntityManager();

		Course st = em.find(Course.class, course_id);

		if (st == null) {
			throw new CourseException("course not found...");
		}

		System.out.println(st.toString());
	}

}

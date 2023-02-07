package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.model.Course;
import com.masai.model.Student;

public class AddCourseUseCase {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter course name :- ");
		String cName = sc.next();
		
		System.out.println("enter course duration :- ");
		String cDuration = sc.next();
		
		System.out.println("enter course fee :- ");
		int cfee = sc.nextInt();
		
		Student st = new Student("ram", "ram@123", "123456");
		Student st2 = new Student("shyam", "s@123", "123ssss");
		
		StudentDao sod = new StudentDao();
		
		Course c = new Course(cName, cDuration, cfee);
		
		c.getStudentList().add(st);
		c.getStudentList().add(st2);
		
		sod.addCourse(c);
		
	}

}

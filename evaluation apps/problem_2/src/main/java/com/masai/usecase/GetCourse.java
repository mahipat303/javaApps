package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.exception.CourseException;

public class GetCourse {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter Course id :- ");
		int id = sc.nextInt();

		StudentDao sdo = new StudentDao();

		try {
			sdo.getCourse(id);
		} catch (CourseException e) {
			System.out.println(e.getMessage());
		}

		sc.close();
	}
}

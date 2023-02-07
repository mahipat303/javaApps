package com.masai.usecase;

import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.exception.StudentException;


public class GetStudentUsecase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("enter student id :- ");
		int id = sc.nextInt();

		StudentDao sdo = new StudentDao();

		try {
			sdo.getStudent(id);
		} catch (StudentException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}

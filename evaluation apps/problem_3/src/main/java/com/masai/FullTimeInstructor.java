package com.masai;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("1")
public class FullTimeInstructor extends Instructor {

	private int salary;
	private String email;

	public FullTimeInstructor(String name, int salary, String email) {
		super(name);
		this.salary = salary;
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FullTimeInstructor [salary=" + salary + ", email=" + email + "]";
	}

}

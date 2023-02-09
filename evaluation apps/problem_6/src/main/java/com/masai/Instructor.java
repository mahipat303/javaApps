package com.masai;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedNativeQuery;

import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType = DiscriminatorType.INTEGER)
@NamedNativeQuery(query = "select * from Instructor i where i.type = :type", name="getFullTime")
@NamedQuery(query = "select i from Instructor i where i.instructorId = :?",name = "getById")
abstract class Instructor {

	public Instructor(String name) {
		this.instructorName = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int instructorId;

	private String instructorName;

	

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", instructorName=" + instructorName + "]";
	}

}

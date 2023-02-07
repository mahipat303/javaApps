package com.masai;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("2")
public class PartTimeInstructor extends Instructor {

	private int noOfSession;
	private int costPerSession;
	private String mobileNumber;
	
	

	public int getNoOfSession() {
		return noOfSession;
	}

	public PartTimeInstructor(String name, int noOfSession, int costPerSession, String mobileNumber) {
		super(name);
		this.noOfSession = noOfSession;
		this.costPerSession = costPerSession;
		this.mobileNumber = mobileNumber;
	}

	public void setNoOfSession(int noOfSession) {
		this.noOfSession = noOfSession;
	}

	public int getCostPerSession() {
		return costPerSession;
	}

	public void setCostPerSession(int costPerSession) {
		this.costPerSession = costPerSession;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "PartTimeInstructor [noOfSession=" + noOfSession + ", costPerSession=" + costPerSession
				+ ", mobileNumber=" + mobileNumber + "]";
	}
	
	

}

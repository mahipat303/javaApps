package com.masai;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class PhoneNumber {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phoneId;

	private String phoneNumber;

	private PhoneType phoneType;

	@JoinColumn(name = "User")
	 private int userId;

	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType2) {
		this.phoneType = phoneType2;
	}

}

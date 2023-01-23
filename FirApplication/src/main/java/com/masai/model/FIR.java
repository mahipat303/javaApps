package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FIR {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String crimeDetail;
	private LocalDateTime timeStamp;
	private String policeStation;
	
	
	
	public FIR(Integer id, String crimeDetail, LocalDateTime timeStamp, String policeStation) {
		super();
		this.id = id;
		this.crimeDetail = crimeDetail;
		this.timeStamp = timeStamp;
		this.policeStation = policeStation;
	}

	public FIR() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCrimeDetail() {
		return crimeDetail;
	}

	public void setCrimeDetail(String crimeDetail) {
		this.crimeDetail = crimeDetail;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

}

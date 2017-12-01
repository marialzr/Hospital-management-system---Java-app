package com.fortech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="interventions")
@IdClass(MyKey.class)
public class Intervention {
	public Intervention() {
		// TODO Auto-generated constructor stub
	}
	
	// here I don't have did, pid anymore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pid", nullable=false)
	private Patient patient;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="did", nullable=false)
	private Doctor doctor;
	
	@Id
	private String date;
	
	@Column(name="success", nullable = false, columnDefinition="BIT")
	private boolean success;
	
	@Column(name="duration", nullable = false)
	private int duration;
	
	
	public Intervention(Patient patient, Doctor doctor, String date, boolean success, int duration) {
		super();
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
		this.success = success;
		this.duration = duration;
	}

	
	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Intervention [patient=" + patient + ", doctor=" + doctor + ", date=" + date + ", success=" + success
				+ ", duration=" + duration + "]";
	}
	
}

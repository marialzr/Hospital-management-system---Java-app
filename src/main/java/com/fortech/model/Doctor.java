package com.fortech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="doctors")
public class Doctor {
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	
	@Column(name="did")
	@Id
	@GeneratedValue
	private int did;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="no_of_interventions")
	private int noOfInterventions;
	
	@Column(name="years_of_experience")
	private int yearsOfExperience;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL, 
			mappedBy="doctor")
	private List<Intervention> interventions;
	
	public Doctor(int did, String firstName, String lastName, String phone, String email, int noOfInterventions,
			int yearsOfExperience, List<Intervention> interventions) {
		super();
		this.did = did;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.noOfInterventions = noOfInterventions;
		this.yearsOfExperience = yearsOfExperience;
		this.interventions = interventions;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNoOfInterventions() {
		return noOfInterventions;
	}

	public void setNoOfInterventions(int noOfInterventions) {
		this.noOfInterventions = noOfInterventions;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone
				+ ", email=" + email + ", noOfInterventions=" + noOfInterventions + ", yearsOfExperience="
				+ yearsOfExperience + "]";
	}
	
}

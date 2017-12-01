package com.fortech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="patients")
public class Patient {
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	
	@Column(name="pid", nullable = false)
	@Id
	@GeneratedValue
	private int pid;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rid", nullable=false)
	private Room room;

	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@Column(name="phone", nullable = false)
	private String phone;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY,
			cascade = CascadeType.ALL, 
			mappedBy="patient")
	private List<Intervention> interventions;
	
	public Patient(int pid, Room room, String firstName, String lastName, String phone, String email,
			List<Intervention> interventions) {
		super();
		this.pid = pid;
		this.room = room;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.interventions = interventions;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
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

	public List<Intervention> getInterventions() {
		return interventions;
	}

	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", room=" + room + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", email=" + email + "]";
	}

	

}
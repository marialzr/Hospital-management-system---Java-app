package com.fortech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="rooms")
public class Room {
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Column(name="rid", unique = true, nullable = false)
	@Id
	@GeneratedValue
	private int rid;
	
	@Column(name="no_of_patients", nullable = false)
	private int no_of_patients;

	@Column(name="floor", nullable = false)
	private int floor;
	
	@OneToMany(fetch = FetchType.LAZY,
	cascade = CascadeType.ALL, 
	mappedBy="room")
	private List<Patient> patients;

	public Room(int rid, int no_of_patients, int floor, List<Patient> patients) {
		super();
		this.rid = rid;
		this.no_of_patients = no_of_patients;
		this.floor = floor;
		this.patients = patients;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getNo_of_patients() {
		return no_of_patients;
	}

	public void setNo_of_patients(int no_of_patients) {
		this.no_of_patients = no_of_patients;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Room [rid=" + rid + ", no_of_patients=" + no_of_patients + ", floor=" + floor+ "]";
	}

	
}

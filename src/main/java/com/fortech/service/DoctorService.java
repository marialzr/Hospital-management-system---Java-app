package com.fortech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortech.model.Doctor;
import com.fortech.repository.IDoctorRepository;


@Service
public class DoctorService {
	@Autowired  //face bean sa nu mai fac instanta
	private IDoctorRepository repo;
	
	public List<Doctor> getAllDoctors(){
		List<Doctor> l = new ArrayList<Doctor>();
		repo.findAll().forEach(l::add);
		return l;
	} 
	
	public Doctor getDoctorById(int id) {
		return repo.findBydid(id);
	}
	
	public void add(Doctor d) {
		repo.add(d.getFirstName(), d.getLastName(), d.getPhone(), d.getEmail(), d.getYearsOfExperience(), d.getNoOfInterventions());
	}

	public void delete(int id) {
		repo.delete(id);
	}
	
	public void update(Doctor d) {
		repo.update(d.getDid(), d.getFirstName(), d.getLastName(), d.getPhone(), d.getEmail(), d.getYearsOfExperience(), d.getNoOfInterventions());
	}
}

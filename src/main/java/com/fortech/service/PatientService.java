package com.fortech.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortech.model.Patient;
import com.fortech.repository.IPatientRepository;

@Service
public class PatientService {
	@Autowired  //face bean sa nu mai fac instanta
	private IPatientRepository repo;
	public List<Patient> getAllPatients(){
		List<Patient> l = new ArrayList<Patient>();
		repo.findAll().forEach(l::add);
		return l;
	}
	
	public Patient getPatientById(int id) {
		return repo.findBypid(id);
	}
	
	public void add(Patient p) {
		repo.save(p);
	}

	public void delete(int id) {
		repo.delete(id);
	}
	
	public void update(Patient p) {
		repo.update(p.getPid(), p.getRoom().getRid(),p.getFirstName(), p.getLastName(), p.getPhone(), p.getEmail());
	}
}

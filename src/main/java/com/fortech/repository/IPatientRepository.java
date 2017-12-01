package com.fortech.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fortech.model.Patient;

@Repository
public interface IPatientRepository extends CrudRepository<Patient,Integer> {
	public Patient findBypid(int nr);
	
	@Modifying
    @Query(value = "update Patients set rid=:room, first_name=:fn, last_name=:ln, phone=:p, email=:e where pid=:id", nativeQuery = true)
    @Transactional
	void update(int id, int room,String fn, String ln, String p, String e);
}
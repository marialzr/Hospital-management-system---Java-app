 package com.fortech.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fortech.model.Doctor;

@Repository
public interface IDoctorRepository extends CrudRepository<Doctor,Integer> {
	public Doctor findBydid(int nr);
	
	@Modifying
    @Query(value = "insert into Doctors (first_name,last_name, phone, email, years_of_experience, no_of_interventions) "
    		+ "VALUES (:fn,:ln, :ph, :email, :y, :no)", nativeQuery = true)
    @Transactional
    void add(String fn, String ln, String ph, String email, int y, int no);
	
	@Modifying
    @Query(value = "delete from Doctors where did=:id", nativeQuery = true)
    @Transactional
	void delete(int id);
	
	@Modifying
    @Query(value = "update Doctors set first_name=:fn, last_name=:ln, phone=:p, email=:e, "
    		+ "years_of_experience=:y, no_of_interventions=:no where did=:id", nativeQuery = true)
    @Transactional
	void update(int id, String fn, String ln, String p, String e, int y, int no);
}



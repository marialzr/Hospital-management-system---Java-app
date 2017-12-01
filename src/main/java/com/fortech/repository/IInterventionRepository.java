package com.fortech.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fortech.model.Doctor;
import com.fortech.model.Intervention;
import com.fortech.model.MyKey;
import com.fortech.model.Patient;

@Repository
public interface IInterventionRepository extends CrudRepository<Intervention,MyKey> {
	public Intervention findByDoctorAndPatientAndDate(Doctor doctor, Patient patient, Date date);
	
	@Modifying
    @Query(value = "insert into Interventions(did, pid, date, success, duration) VALUES "
    		+ "(:did,:pid, :date, :s, :dur)", nativeQuery = true)
    @Transactional
    void add(int did, int pid, Date date, boolean s, int dur );
}

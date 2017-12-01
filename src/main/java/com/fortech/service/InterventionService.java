package com.fortech.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortech.model.Intervention;
import com.fortech.repository.IInterventionRepository;


@Service
public class InterventionService {
	@Autowired  //face bean sa nu mai fac instanta
	private IInterventionRepository repo;
	public List<Intervention> getAllInterventions(){
		List<Intervention> l = new ArrayList<Intervention>();
		repo.findAll().forEach(l::add);
		return l;
	}
	
	public void add(Intervention d) {
		
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date result;
		try {
			result = formatter.parse(d.getDate());
			repo.add(d.getDoctor().getDid(),d.getPatient().getPid(),result,d.isSuccess(),d.getDuration());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//repo.save(d);
	}
}

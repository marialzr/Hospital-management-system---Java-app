package com.fortech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fortech.model.Doctor;
import com.fortech.model.Intervention;
import com.fortech.model.Patient;
import com.fortech.service.DoctorService;
import com.fortech.service.InterventionService;
import com.fortech.service.PatientService;


@RestController
public class InterventionController {
	@Autowired
	private InterventionService service;
	
	@Autowired
	private DoctorService dservice;
	
	@Autowired
	private PatientService pservice;

	@RequestMapping(method = RequestMethod.GET, value = "/interventions")
	public List<Intervention> getAllDoctors() {
		List<Intervention> l=service.getAllInterventions();
		for(Intervention p:l) {
			System.out.println(p.toString());
		}
		return l;
	}
	
	@RequestMapping(value = { "/interventions/add" }, method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        Intervention p = new Intervention();
        model.getModel().put("patient", p);
        model.setViewName("addIntervention");
        return model;
    }
	 
	 @RequestMapping(method = RequestMethod.POST, value = "/interventions/newi")
		public ModelAndView save(ModelAndView model, @ModelAttribute Intervention intervention) {
			service.add(intervention);
		    model.setViewName("home");  
			return model;
		}
	 
	 @ModelAttribute("patients")
	    public List<Patient> initializePatients() {
		 	return pservice.getAllPatients();
	    }
	 
	 @ModelAttribute("doctors")
	    public List<Doctor> initializeDoctors() {
		 	return dservice.getAllDoctors();
	    }
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/interventions/view")
		public ModelAndView test(ModelAndView model) {
		      model.setViewName("viewIntervention");
		      List<Intervention> l=service.getAllInterventions();
		      model.getModel().put("interventions", l);
			return model;
		}
	 
}

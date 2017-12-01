package com.fortech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fortech.model.Patient;
import com.fortech.model.Room;
import com.fortech.service.PatientService;
import com.fortech.service.RoomService;

@RestController
public class PatientController {
	@Autowired
	private PatientService service;
	@Autowired
	private RoomService roomService;

	@RequestMapping(method = RequestMethod.GET, value = "/patients/get")
	public List<Patient> getAllPatients() {
		List<Patient> l=service.getAllPatients();
		for(Patient p:l) {
			System.out.println(p.toString());
		}
		return l;
	}
	
	@RequestMapping(value = { "patients/add" }, method = RequestMethod.GET)
    public ModelAndView newUser(ModelAndView model) {
        Patient p = new Patient();
        model.getModel().put("patient", p);
        model.setViewName("addPatient");
        return model;
    }
	 
	 @RequestMapping(method = RequestMethod.POST, value = "/patients/newp")
		public ModelAndView save(ModelAndView model, @ModelAttribute Patient patient) {
			service.add(patient);
		    model.setViewName("home");  
			return model;
		}
	
	@ModelAttribute("rooms")
    public List<Room> initializeProfiles() {
        return roomService.findAll();
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/patients/view/{id}")
	public ModelAndView test(ModelAndView model, @PathVariable("id") int id) {
	      model.setViewName("viewPatient");
	      List<Patient> l=service.getAllPatients();
	      Patient p=service.getPatientById(id);
	      model.getModel().put("patient", p);
	      model.getModel().put("patients", l);
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/patients/delete/{id}")
	public ModelAndView deleteDoctor(ModelAndView model, @PathVariable("id") int id) {
		service.delete(id);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="patients/update/{id}")
	public ModelAndView updatePatient(ModelAndView model, @PathVariable int id) {
		model.getModel().put("patient", service.getPatientById(id));
		model.setViewName("updatePatient");  
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/patients/update")
	public ModelAndView updatedb(ModelAndView model, @ModelAttribute Patient p) {
		service.update(p);
	    model.setViewName("home");  
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/home")
	public ModelAndView home(ModelAndView model) {
		model.setViewName("home");
		return model;
	}
}



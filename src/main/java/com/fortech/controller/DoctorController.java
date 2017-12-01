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
import com.fortech.service.DoctorService;


@RestController
public class DoctorController {
	@Autowired
	private DoctorService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "/doctors/get")
	public List<Doctor> getAllDoctors() {
		List<Doctor> l=service.getAllDoctors();
		for(Doctor p:l) {
			System.out.println(p.toString());
		}
		return l;
	}
	
	Doctor getDoctorById(int id) {
		return service.getDoctorById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/doctors/view/{id}")
	public ModelAndView test(ModelAndView model, @PathVariable("id") int id) {
	      model.setViewName("viewDoctor");
	      List<Doctor> l=this.getAllDoctors();
	      Doctor d=this.getDoctorById(id);
	      model.getModel().put("doctor", d);
	      model.getModel().put("doctors", l);
		return model;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/doctors/add")
	public ModelAndView testAdd(ModelAndView model, @ModelAttribute Doctor doctor) {
	    model.setViewName("addDoctor");  
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/doctors/save")
	public ModelAndView save(ModelAndView model, @ModelAttribute Doctor doctor) {
		service.add(doctor);
	    model.setViewName("home");  
		return model;
	}	
	
	@RequestMapping(method=RequestMethod.GET, value="doctors/update/{docId}")
	public ModelAndView updateDoctor(ModelAndView model, @PathVariable Integer docId) {
		model.getModel().put("doctor", service.getDoctorById(docId));
		model.setViewName("updateDoctor");  
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/doctors/update")
	public ModelAndView updatedb(ModelAndView model, @ModelAttribute Doctor doctor) {
		service.update(doctor);
	    model.setViewName("home");  
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/doctors/delete/{id}")
	public ModelAndView deleteDoctor(ModelAndView model, @PathVariable("id") int id) {
		service.delete(id);
		model.setViewName("home");
		return model;
	}
}

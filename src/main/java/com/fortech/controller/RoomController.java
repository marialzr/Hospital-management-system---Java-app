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
import com.fortech.service.RoomService;


@RestController
public class RoomController {
	@Autowired
	private RoomService service;
	@RequestMapping(method = RequestMethod.GET, value = "/rooms")
	public List<Room> getAllRooms() {
		List<Room> l=service.findAll();
		for(Room r:l) {
			System.out.println(r.toString());
		}
		return l;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/patients/viewByRoom/{id}")
	public ModelAndView viewByRoom(ModelAndView model, @PathVariable("id") int id) {
	      model.setViewName("patientsByRoom");
	      Room r=service.getRomById(id);
	      List<Room> rooms=service.findAll();
	      model.getModel().put("room", r);
	      model.getModel().put("rooms", rooms);
	      for (Patient p:r.getPatients()) {
	    	  System.out.println(p.getPid());
	      }
		return model;
	}
}

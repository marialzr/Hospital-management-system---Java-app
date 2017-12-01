package com.fortech.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fortech.model.Doctor;
import com.fortech.model.Room;
import com.fortech.repository.IRoomRepository;

@Service
public class RoomService {
	@Autowired
	private IRoomRepository repo;
	public List<Room> findAll(){
		List<Room> l = new ArrayList<Room>();
		repo.findAll().forEach(l::add);
		return l;
	}
	public Room getRomById(int id) {
		return repo.findByrid(id);
	}
}

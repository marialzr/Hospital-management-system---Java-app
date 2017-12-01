package com.fortech.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fortech.model.Room;

@Repository
public interface IRoomRepository extends CrudRepository<Room,Integer>{
	public Room findByrid(int nr);
	
	@Modifying
    @Query(value = "insert into Rooms (no_of_patients,floor) VALUES (:no,:f)", nativeQuery = true)
    @Transactional
    void add(int no, int f);
	
	@Modifying
    @Query(value = "delete from Rooms where rid=:id", nativeQuery = true)
    @Transactional
	void delete(int id);
	
	@Modifying
    @Query(value = "update Doctors set no_of_patients=:no, floor=:f where rid=:id", nativeQuery = true)
    @Transactional
	void update(int no, int f);
}
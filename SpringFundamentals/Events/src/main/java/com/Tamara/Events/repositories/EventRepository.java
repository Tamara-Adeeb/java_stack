package com.Tamara.Events.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Tamara.Events.models.Event;



@Repository
public interface EventRepository extends CrudRepository <Event,Long> {
	List<Event> findAll();
//	@Query(value="SELECT * FROM events WHERE state = ?1", nativeQuery=true)
//	List<Event> findAllEventsByState(String state);
	
	@Query("SELECT e FROM Event e  WHERE state = ?1")
	List<Event> findAllEventsByState(String state);
	
	List<Event> findByState(String state);
	
	@Query(value="SELECT * FROM events WHERE state NOT IN (?1)",nativeQuery=true)
	List<Event> findAllEventNotInState(String state);
}

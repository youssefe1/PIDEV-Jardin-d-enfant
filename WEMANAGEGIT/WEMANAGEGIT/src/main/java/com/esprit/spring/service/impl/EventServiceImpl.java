package com.esprit.spring.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.Event;
import com.esprit.spring.repository.IEventRepository;
import com.esprit.spring.service.IEventSerivce;

@Service
public class EventServiceImpl implements IEventSerivce {
	
	@Autowired
	IEventRepository eventrepository;

	@Override
	public List<Event> getAllEvent() {
		return (List<Event>) eventrepository.findAll();
	}

	@Override
	public Event getEventById(Long Id) {
		return eventrepository.findById(Id).orElse(null);
	}

	@Override
	public Event addEvent(Event e) {
		
		 return eventrepository.save(e);
		
	}

	@Override
	public Event updateEvent(Long Id,Event e) {
		Event event = getEventById(Id);
	       
	        return eventrepository.save(event);
		
		
	}



	@Override
	public Event getEventByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public Event addEvent(Event e) {
		// TODO Auto-generated method stub
		return null;
	}*/

	

	@Override
	public Event deleteEventById(Long Id) {
		 Event event=eventrepository.findById(Id).orElse(null);
	       
	        eventrepository.deleteById(Id);
	        return event;
	}
	
	/*@Override
	public void deleteEventById(long IdEvenement) {
		Event event = eventrepository.findById((long) IdEvenement).get();
		eventrepository.deleteById(IdEvenement);
		
	}*/

}

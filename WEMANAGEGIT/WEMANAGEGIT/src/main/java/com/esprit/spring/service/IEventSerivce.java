package com.esprit.spring.service;

import java.util.Date;
import java.util.List;

import com.esprit.spring.entities.Event;
	List<Event> getAllEvent();
	
	public Event getEventById(Long Id);
	public Event addEvent(Event e);
	public Event updateEvent(Long Id,Event e);
	public Event deleteEventById(Long Id);
	public Event getEventByDate (Date date);
	

}

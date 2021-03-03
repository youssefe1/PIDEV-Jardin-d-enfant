package com.esprit.spring.service;

import java.util.Date;
import java.util.List;

import com.esprit.spring.entities.Event;

public interface IEventSerivce {

	List<Event> getAllEvent();
	
	public Event getEventById(long IdEvenement);
	public Event addEvent(Event e);
	public Event updateEvent(Event e, long IdEvenement);
	public Event deleteEventById(long IdEvenement);
	public Event getEventByDate (Date date);
	

}

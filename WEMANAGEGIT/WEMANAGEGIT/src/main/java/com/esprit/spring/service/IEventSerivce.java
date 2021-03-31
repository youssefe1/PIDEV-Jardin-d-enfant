package com.esprit.spring.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.esprit.spring.entities.Event;
import com.esprit.spring.entities.EventCategory;
import com.esprit.spring.entities.EventEtat;
import com.esprit.spring.entities.EventGallery;
import com.esprit.spring.entities.EventType;





public interface IEventSerivce {

	Iterable<Event> getAllEvent(int offset, int limit);
	List<Event> findAllOrderByDateAsc();
    //List<Event> findAllOrderByDateDes();
	public Event getEventById(Long Id);
	public Event addEvent(Event e);
	public Event updateEvent(Long Id,Event e);
	public Event deleteEventById(Long Id);
	public Event getEventByDate (Date date);
	
	public List<String> getAllEventByCategorie (EventCategory categorie);
    public Event getEventoftoday();
    public void verifier_etat_event();
     
    public Event geteventbyid (long Id);
   
	public List<Event> filterevents(EventCategory categorie,EventType type, EventEtat etat);
	public void addimageevent(Long Id,String image,Date date);	
	public List<EventGallery> listimagesevent(Long Id);

}


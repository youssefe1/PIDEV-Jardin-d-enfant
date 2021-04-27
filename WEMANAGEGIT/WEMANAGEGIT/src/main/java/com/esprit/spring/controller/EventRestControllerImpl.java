package com.esprit.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.esprit.spring.entities.Event;
import com.esprit.spring.entities.EventCategory;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.IEventRepository;
import com.esprit.spring.service.IEventInvitationService;
import com.esprit.spring.service.EventServiceImpl;





@RestController
public class EventRestControllerImpl {
	
	@Autowired
    EventServiceImpl eventservice;
 
 @Autowired
 	IEventRepository EventR;
 @Autowired
	IEventInvitationService EventInvitation;
 
 @GetMapping("/getEvent")
 @ResponseBody
 public Iterable<Event> getAllEvent(@RequestParam("offset") int offset, @RequestParam("limit") int limit){
	 return eventservice.getAllEvent(offset, limit);
 }
 
 
 @PostMapping("/addEvent")
 @ResponseBody
 public Event addEvent(@RequestBody Event e){
	return eventservice.addEvent(e);
 }
 
 @PutMapping("/updateevent/{Id}")
 @ResponseBody
 public Event updateEvent(@PathVariable("Id") Long Id,@RequestBody Event e){
	return eventservice.updateEvent(Id,e);
 }
 
 
 
  
 
 @DeleteMapping("/deleteevent/{Id}")
 public Event deleteEventById(@PathVariable("Id") Long Id){
	 return eventservice.deleteEventById(Id);
 }
 
 @GetMapping(value = "/EventSotedByDate")
 public List<Event> getEventByDate() {

     return eventservice.findAllOrderByDateAsc();
 }

 @GetMapping(path="/event_categorie/{categorie}")
	@ResponseBody
	public List<String> getAllEventByCategorie(@PathVariable("categorie") EventCategory categorie ) {
		
	return eventservice.getAllEventByCategorie(categorie);
	
	 }
 
	@GetMapping(path="/event_oftheday")
	@ResponseBody
	public Event Event_oftoday() {
				
	return eventservice.getEventoftoday();

	}
	
	@PostMapping("/inviter_user/{idevent}/{iduser}")
	@ResponseBody
	
	public void inviter_user_event(@PathVariable("idevent")Long idevent,@PathVariable("iduser")Long iduser) {
		EventInvitation.inviter_user_event(idevent, iduser);
     }
	
	@GetMapping(path="/Liste_Participants/{idevent}")
	@ResponseBody
	public List<User> listUsersparticipes(@PathVariable("idevent")Long idevent) {
		return EventInvitation.listUsersparticipes(idevent);
	}
 }
 
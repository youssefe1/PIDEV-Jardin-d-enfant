package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entities.Event;
import com.esprit.spring.repository.IEventRepository;
import com.esprit.spring.service.EventServiceImpl;


@RestController
@RequestMapping("")
public class EventRestControllerImpl {
	
	@Autowired
    EventServiceImpl eventservice;
 
 @Autowired
 	IEventRepository EventR;
 
 @GetMapping("/getEvent")
 @ResponseBody
 public List<Event> getAllEvent(){
	 return eventservice.getAllEvent();
 }
 
 
 @PostMapping("/addEvent")
 @ResponseBody
 public Event addEvent(@RequestBody Event e){
	return eventservice.addEvent(e);
 }
 
 @PutMapping("/updateevent/{id}")
 @ResponseBody
 public Event updateEvent(@PathVariable("IdEvenement") Long IdEvenement,@RequestBody Event e){
	return eventservice.updateEvent(e, IdEvenement);
 }
 
 @DeleteMapping("/deleteevent/{id}")
 public Event deleteEventById(@PathVariable("IdEvenement") Long IdEvenement){
	 return eventservice.deleteEventById(IdEvenement);
 }

 
 
 }

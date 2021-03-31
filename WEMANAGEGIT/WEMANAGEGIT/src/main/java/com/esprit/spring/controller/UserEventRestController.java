package com.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entities.EventInvitationEtat;
import com.esprit.spring.repository.IEventRepository;
import com.esprit.spring.service.IEventInvitationService;
import com.esprit.spring.service.EventServiceImpl;


@RestController
public class UserEventRestController {
	@Autowired
    EventServiceImpl eventservice;
 
 @Autowired
 	IEventRepository EventR;
 @Autowired
	IEventInvitationService EventInvitation;
 @PutMapping(value = "/participer_event/{idevent}/{iduser}/{etat}") 
	public void participer_user_event(@PathVariable("idevent")Long idevent,@PathVariable("iduser")Long iduser,@PathVariable("etat")  EventInvitationEtat etat) {
	 EventInvitation.participer_user_event(idevent,iduser,etat);
		
	}
	@PutMapping(value = "/annuler_participer_event/{idevent}/{iduser}/{etat}") 
	public void annulerparticiperaevent(@PathVariable("idevent")Long idevent,@PathVariable("iduser")Long iduser,@PathVariable("etat")  EventInvitationEtat etat) {
		 EventInvitation.annuler_participation_event(idevent, iduser,etat );
}}

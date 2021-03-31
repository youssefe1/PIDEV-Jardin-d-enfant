package com.esprit.spring.service;

import java.util.List;


import com.esprit.spring.entities.EventEtat;
import com.esprit.spring.entities.EventInvitationEtat;
import com.esprit.spring.entities.EventParticipantsInvitation;
import com.esprit.spring.entities.User;


public interface IEventInvitationService {
	
    public EventParticipantsInvitation getinvitationevent(Long idevent,String username);
	public void inviter_user_event(Long idevent,Long iduser);
	

	public void participer_user_event(Long idevent,Long iduser, EventInvitationEtat etat);
	
	public void annuler_participation_event(Long idevent,Long iduser,EventInvitationEtat etat);
	
	public List<User> listUsersparticipes(Long idevent);
	


}

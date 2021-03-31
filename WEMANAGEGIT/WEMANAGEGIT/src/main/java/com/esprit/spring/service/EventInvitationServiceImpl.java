package com.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.Event;
import com.esprit.spring.entities.EventInvitationEtat;
import com.esprit.spring.entities.EventParticipantsInvitation;

import com.esprit.spring.entities.Pk;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.IEventParticipantsInvitation;
import com.esprit.spring.repository.IEventRepository;
import com.esprit.spring.repository.IUserRepository;

import com.esprit.spring.service.IEventInvitationService;
import com.esprit.spring.service.MyUserService;





@Service
public class EventInvitationServiceImpl implements IEventInvitationService {

	@Autowired
	IUserRepository userrepository ;
	
    @Autowired
	IEventRepository eventrepository ;
	
    
    @Autowired
    IEventParticipantsInvitation invitationrepository ;
    @Autowired
	MyUserService userservices ;
   
    
	@Override
	public EventParticipantsInvitation getinvitationevent(Long idevent,String username) {
		return null;
		
	}

	@Override
	public void inviter_user_event(Long idevent, Long iduser) {
		
        Date date = new Date();
		Event e = eventrepository.findById(idevent).get();
		User u = userrepository.findById(iduser).get();
		
				
				Pk invitationpk = new Pk();
				
				invitationpk.setEvId(idevent);
				invitationpk.setUsId(iduser);
				
				EventParticipantsInvitation invitation = new EventParticipantsInvitation();
				invitation.setPk(invitationpk);
				invitation.setAnswer("en_attente");
				invitation.setInvitationDate(date);
				invitationrepository.save(invitation);
				e.setNbr_invites(e.getNbr_invites()+1);
				eventrepository.save(e);
				
}
			


	@Override
	public void participer_user_event(Long idevent,Long iduser,  EventInvitationEtat etat) {
		Date date = new Date();
		
		User user = userrepository.findById(iduser).get();
		Event event = eventrepository.findById(idevent).get();
		EventParticipantsInvitation invitation = invitationrepository.getinvitation(user, event);
		
      if (user.getInvitations().contains(invitation)){
			
			if (invitation.getAnswer().equals("en_attente")){
				event.setNbr_invites(event.getNbr_invites()-1);
				
			}
			
			if (invitation.getAnswer().equals("participe"))
			{
				
					System.out.println("cet evenement  avec l'id " + idevent + " est deja participe ")	;

			}
		
				else {
						
					/*
					 * if (invitation.getAnswer().equals("intéressé")) {
					 */
							
							invitation.setAnswer_date(date);
							invitation.setAnswer("participe");
							event.setNbr_participants(event.getNbr_participants()+1 );
							eventrepository.save(event);
							
					    }
			
			invitationrepository.save(invitation);
				}
		
	}

	@Override
	public void annuler_participation_event(Long idevent, Long iduser, EventInvitationEtat etat) {
		
		Date date = new Date();		
		User user = userrepository.findById(iduser).get();
		Event event = eventrepository.findById(idevent).get();
		EventParticipantsInvitation invitation = invitationrepository.getinvitation(user, event);
		
		if(event.getDate_event().after(date))
		{
		invitation.setAnswer_date(date);
		invitation.setAnswer("annulé");
		event.setNbr_participants(event.getNbr_participants()-1);
		eventrepository.save(event);
		invitationrepository.save(invitation);
		}
		
		else System.out.println("le event est deja en cours ");
	}
	@Override
	public List<User> listUsersparticipes(Long idevent) {
		Event event = eventrepository.findById(idevent).get();
		return invitationrepository.listuserparticipes(event);
	}
	
}

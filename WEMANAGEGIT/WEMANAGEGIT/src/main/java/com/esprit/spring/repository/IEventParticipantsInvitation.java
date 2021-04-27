package com.esprit.spring.repository;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.EventParticipantsInvitation;
import com.esprit.spring.entities.Event;
import com.esprit.spring.entities.Parent;
import com.esprit.spring.entities.User;




@Repository
public interface IEventParticipantsInvitation extends CrudRepository<EventParticipantsInvitation,Long> {
	
    @Query("Select i from EventParticipantsInvitation i where i.UserInvitation=:user and i.EventInvitation=:event")
	public EventParticipantsInvitation getinvitation (@Param("user")User user,@Param("event")Event event);
	
	
	@Query("Select i.EventInvitation from EventParticipantsInvitation i where i.answer='participe' and i.UserInvitation=:user and i.EventInvitation.eventEtat='a_venir'")
	public List<Event> listeventsparticipated(@Param("user")User user);
	
	@Query("Select i.UserInvitation from EventParticipantsInvitation i where i.answer='participe' and i.EventInvitation=:event")
	public List<User> listuserparticipes(@Param("event")Event event) ;
	
	
}

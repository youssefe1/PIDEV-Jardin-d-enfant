package com.esprit.spring.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class EventParticipantsInvitation implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Pk pk;
	
	    @Column(name="Invitation_Date")
		private Date invitationDate ;
	    
	    @Column(name="Answer_Date")
		private Date answer_date ;
	    
	    private String answer ;
	
	
	 
	@ManyToOne
    @JoinColumn(name = "usId",referencedColumnName="Id",insertable = false, updatable = false)
	private User UserInvitation;

    @ManyToOne
    @JoinColumn(name = "evId",referencedColumnName="Id",insertable = false, updatable = false)
    private Event EventInvitation;

	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
		this.pk = pk;
	}

	public Date getInvitationDate() {
		return invitationDate;
	}

	public void setInvitationDate(Date invitationDate) {
		this.invitationDate = invitationDate;
	}

	public Date getAnswer_date() {
		return answer_date;
	}

	public void setAnswer_date(Date answer_date) {
		this.answer_date = answer_date;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public User getUserInvitation() {
		return UserInvitation;
	}

	public void setUserInvitation(User userInvitation) {
		UserInvitation = userInvitation;
	}

	public Event getEventInvitation() {
		return EventInvitation;
	}

	public void setEventInvitation(Event eventInvitation) {
		EventInvitation = eventInvitation;
	}

    
    
}

   




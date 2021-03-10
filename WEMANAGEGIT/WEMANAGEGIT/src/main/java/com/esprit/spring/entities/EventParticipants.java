package com.esprit.spring.entities;
import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@Entity
public class EventParticipants implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Pk pk;
	
	
	 
	@ManyToOne
    @JoinColumn(name = "usId",referencedColumnName="Id",insertable = false, updatable = false)
	private User user;

    @ManyToOne
    @JoinColumn(name = "evId",referencedColumnName="Id",insertable = false, updatable = false)
    private Event event;
}

   




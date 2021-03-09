package com.esprit.spring.entities;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Pk implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int userId;
	private int eventId;
	
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}


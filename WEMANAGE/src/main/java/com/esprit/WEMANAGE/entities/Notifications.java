package com.esprit.WEMANAGE.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Notifications implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  long Id;
	
	private String Body ;
	private Date CreatedAt ;
	private String Link ;
	private String NotifType ;
	private Boolean  Seen ;
	
	
	@ManyToOne
	private User user ;
	
	
	
	
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public Date getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getNotifType() {
		return NotifType;
	}
	public void setNotifType(String notifType) {
		NotifType = notifType;
	}
	public Boolean getSeen() {
		return Seen;
	}
	public void setSeen(Boolean seen) {
		Seen = seen;
	} 
	
}

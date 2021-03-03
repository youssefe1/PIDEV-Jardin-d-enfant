package com.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
@Entity
public class Notification implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long Id;
	
	private String Body ;
	private Date CreatedAt ;
	private String Link ;
	private String NotifType ;
	private Boolean  Seen ;
	
	
	@ManyToOne
	private User user ;
	@Transient
	private Long user_id ;
	
	
	public Notification() {
		super();
	}
	public Notification( String body, Date createdAt, String link, String notifType, Boolean seen) {
		super();
		Body = body;
		CreatedAt = createdAt;
		Link = link;
		NotifType = notifType;
		Seen = seen;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	} 
	
	
}

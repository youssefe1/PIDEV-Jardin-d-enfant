package com.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Message implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  Long Id;
	
	@Column(name = "Body")
	private String Body  ;
	@Temporal(TemporalType.DATE)
    private Date CreatedAt ;
	
	
	@ManyToOne
	private User user ;
	@Transient
	private Long user_id ; 
	
	
	public Message() {
		super();
	}
	
	public Message( String body, Date createdAt) {
		super();
		Body = body;
		CreatedAt = createdAt;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	

}

package com.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
@Table(name = "Message")
public class Message implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private  long Id;
	
	@Column(name = "Body")
	private String Body  ;
	@Column(name = "CreatedAt")
    private Date CreatedAt ;
	
	
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
	

}

package com.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
public class Message implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private MessageType type;
    private String body;
    @ManyToOne
    private User sender;
  //  private User user;
    private Date date;
	/*@ManyToOne
	private User user ;
	*/
	@Transient
	private Long user_id ; 
	
	
    public Message() {
		super();
	}
    
    
    
public Message(MessageType type, String body, User sender, Date date) {
		super();
		this.type = type;
		this.body = body;
		this.sender = sender;
		this.date = date;
	}

	public long getId() {
	return id;
}



public void setId(long id) {
	this.id = id;
}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }



	public User getSender() {
		return sender;
	}



	public void setSender(User sender) {
		this.sender = sender;
	}



}

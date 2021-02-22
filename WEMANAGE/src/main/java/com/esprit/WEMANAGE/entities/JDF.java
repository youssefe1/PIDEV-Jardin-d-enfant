package com.esprit.WEMANAGE.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
public class JDF {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ; 
	private Long Id_User;
	@Temporal(TemporalType.DATE)
	private Date Date_Creation;
	private String Logo;
	private int Review;
	private String Adresse;
	 @Email(message="Please provide a valid email address")
	    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String Email;
	

}

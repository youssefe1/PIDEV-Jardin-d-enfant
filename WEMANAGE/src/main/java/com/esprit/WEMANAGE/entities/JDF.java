package com.esprit.WEMANAGE.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.ManyToAny;

import antlr.collections.List;

@Entity
public class JDF implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ; 
	private String Description;
	private int NBR_Emp;
	@Temporal(TemporalType.DATE)
	private Date Date_Creation;
	private String Logo;
	private float fee ;
	private int Review;
	private String Localisation;
	 @Email(message="Please provide a valid email address")
	    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
	private String Email;
	 @ManyToMany
	    List <User> users;
	 
	 
	 
	 
	public JDF(Long id, String description, int nBR_Emp, Date date_Creation, String logo, float fee, int review,
			String localisation,
			@javax.validation.constraints.Email(message = "Please provide a valid email address") @Pattern(regexp = ".+@.+\\..+", message = "Please provide a valid email address") String email) {
		super();
		Id = id;
		Description = description;
		NBR_Emp = nBR_Emp;
		Date_Creation = date_Creation;
		Logo = logo;
		this.fee = fee;
		Review = review;
		Localisation = localisation;
		Email = email;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNBR_Emp() {
		return NBR_Emp;
	}
	public void setNBR_Emp(int nBR_Emp) {
		NBR_Emp = nBR_Emp;
	}
	public Date getDate_Creation() {
		return Date_Creation;
	}
	public void setDate_Creation(Date date_Creation) {
		Date_Creation = date_Creation;
	}
	public String getLogo() {
		return Logo;
	}
	public void setLogo(String logo) {
		Logo = logo;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public int getReview() {
		return Review;
	}
	public void setReview(int review) {
		Review = review;
	}
	public String getLocalisation() {
		return Localisation;
	}
	public void setLocalisation(String localisation) {
		Localisation = localisation;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	 
	 
	 
	
	 

}

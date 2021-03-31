package com.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonCreator;

@Entity
public class FeedBack  implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id ; 
	private String Q1 ;
	private String Q2 ;
	private String Q3 ;
	private String Q4 ;
	private String Q5 ;
	private float note ;
	@ManyToOne
	private Jdf jdf;
	@ManyToMany
    java.util.List<User>users;

	public FeedBack(){
		super();
	}
    

	
	public FeedBack( String q1, String q2, String q3, String q4, String q5, float note, Jdf jdf) {
		super();
		
		Q1 = q1;
		Q2 = q2;
		Q3 = q3;
		Q4 = q4;
		Q5 = q5;
		this.note = note;
		this.jdf = jdf;
		
	}

	/*public FeedBack( String q1, String q2, String q3, String q4, String q5, JDF jdf,float note
			) {
		super();
		
		Q1 = q1;
		Q2 = q2;
		Q3 = q3;
		Q4 = q4;
		Q5 = q5;
		this.jdf = jdf;
		this.note = note;
		
	}

*/
	/*
	public FeedBack(String q1, String q2, String q3, String q4, String q5, float note) {
		super();
		Q1 = q1;
		Q2 = q2;
		Q3 = q3;
		Q4 = q4;
		Q5 = q5;
		this.note = note;
	}

*/

	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getQ1() {
		return Q1;
	}
	public void setQ1(String q1) {
		Q1 = q1;
	}
	public String getQ2() {
		return Q2;
	}
	public void setQ2(String q2) {
		Q2 = q2;
	}
	public String getQ3() {
		return Q3;
	}
	public void setQ3(String q3) {
		Q3 = q3;
	}
	public String getQ4() {
		return Q4;
	}
	public void setQ4(String q4) {
		Q4 = q4;
	}
	public String getQ5() {
		return Q5;
	}
	public void setQ5(String q5) {
		Q5 = q5;
	}
	public float getNote() {
		return note;
	}
	public void setNote(float note) {
		this.note = note;
	}
	public Jdf getJdf() {
		return jdf;
	}
	public void setJdf(Jdf jdf) {
		this.jdf = jdf;
	}
	public java.util.List<User> getUsers() {
		return users;
	}
	public void setUsers(java.util.List<User> users) {
		this.users = users;
	}




}

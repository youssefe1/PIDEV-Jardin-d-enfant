package com.esprit.WEMANAGE.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class FeedBack implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

}

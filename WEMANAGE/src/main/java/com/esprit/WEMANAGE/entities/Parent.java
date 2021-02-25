package com.esprit.WEMANAGE.entities;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Parent  {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Parent ;
	
}

package com.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bus")
public class Bus implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(name="Bus_Area")
	private String Area;
	@Column(name="Bus_NbrPlaceDispo")
	private String NbrPlaceDispo;
	@Column(name="Bus_NbrPlaceMax")
	private String NbrPlaceMax;
	
	
	
	/*@ManyToOne 
	Garden garden;*/
	
	
	
	public Bus(String area, String nbrPlaceDispo, String nbrPlaceMax) {
		super();
		this.Area = area;
		this.NbrPlaceDispo = nbrPlaceDispo;
		this.NbrPlaceMax = nbrPlaceMax;
	}
	public Bus() {
		super();
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getNbrPlaceDispo() {
		return NbrPlaceDispo;
	}
	public void setNbrPlaceDispo(String nbrPlaceDispo) {
		NbrPlaceDispo = nbrPlaceDispo;
	}
	public String getNbrPlaceMax() {
		return NbrPlaceMax;
	}
	public void setNbrPlaceMax(String nbrPlaceMax) {
		NbrPlaceMax = nbrPlaceMax;
	}
	
	
	

}


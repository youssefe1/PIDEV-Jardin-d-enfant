package com.esprit.spring.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;






@Entity
@Table(name="Bus")
public class Bus implements Serializable {

	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="MATRICULE")
	long matricule;
	@Column(name="Driver")
	private String Driver;

	@Column(name="Seat_Capacity")
	private int seatCapacity;

	private String LatStart;  
	private String LonStart; 

	
	private String LatArrival; 
	private String LonArrival; 
	
	@Column(name="Rate")
	private String Rate;
	
	private double Trajet;
	

	public double getTrajet() {
		return Trajet;
	}

	public void setTrajet(double trajet) {
		Trajet = trajet;
	}

	@ManyToOne 
	Jdf kindergarten; 
	
	public Bus() {
		super();
	}

	public long getMatricule() {
		return matricule;
	}

	public void setMatricule(long matricule) {
		this.matricule = matricule;
	}

	public String getDriver() {
		return Driver;
	}

	public void setDriver(String driver) {
		Driver = driver;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}



	public String getLatStart() {
		return LatStart;
	}

	public void setLatStart(String latStart) {
		LatStart = latStart;
	}

	public String getLonStart() {
		return LonStart;
	}

	public void setLonStart(String lonStart) {
		LonStart = lonStart;
	}

	public String getLatArrival() {
		return LatArrival;
	}

	public void setLatArrival(String latArrival) {
		LatArrival = latArrival;
	}

	public String getLonArrival() {
		return LonArrival;
	}

	public void setLonArrival(String lonArrival) {
		LonArrival = lonArrival;
	}


	public String getRate() {
		return Rate;
	}

	public void setRate(String rate) {
		Rate = rate;
	}


	public Jdf getKindergarten() {
		return kindergarten;
	}

	public void setKindergarten(Jdf kindergarten) {
		this.kindergarten = kindergarten;
	}

	public Bus(long matricule, String driver, int seatCapacity, String latStart, String lonStart, String latArrival,
			String lonArrival, double trajet, String rate, Jdf kindergarten, double Trajet) {
		super();
		this.matricule = matricule;
		this.Driver = driver;
		this.seatCapacity = seatCapacity;
		this.LatStart = latStart;
		this.LonStart = lonStart;
		this.LatArrival = latArrival;
		this.LonArrival = lonArrival;
		this.Rate = rate;
		this.kindergarten = kindergarten;
		this.Trajet=Trajet;
	}







	
	

}


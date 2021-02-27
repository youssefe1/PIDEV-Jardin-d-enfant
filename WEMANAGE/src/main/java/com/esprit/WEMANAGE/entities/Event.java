package com.esprit.WEMANAGE.entities;

import java.io.Serializable;
import java.util.Date;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;



@Table(name="Evenement")
@Entity
public class Event implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdEvenement;
	@Column(name="Event_Description")
    private String Description;
	
    @NotNull
    @Column(name="Event_Type")
    @Enumerated(EnumType.STRING)
    
    private String EventType;
    private int Fee_supp;
    @Column(name="Event_Designation")
    private String Designation;
    @Column(name="Event_Participant_nbr")
    private int NbrParticipant_Max;
   
    @Temporal(TemporalType.DATE)
    @Column(name="Event_StartDate")
    private Date StartDate;
    @Column(name="Event_EndDate")
    @Temporal(TemporalType.DATE)
    private Date EndDate;
    
    
    
    @OneToMany(mappedBy = "event")  
    List<EventParticipants> eventParticipants;
	
    /*@ManyToOne  
    public Garden getGarden() {
    	return garden;
    }*/


	public Event() {
		super();
	}
	


	public Event(int fee_supp, @NotNull @Size(min = 20) String description, @NotNull String eventType,
			@NotNull String designation,
			@NotNull(message = "you should defined the max number of the participants") int nbrParticipant_Max,
			Date startDate, Date endDate) {
		super();
		this.Fee_supp = fee_supp;
		this.Description = description;
		this.EventType = eventType;
		this.Designation = designation;
		this.NbrParticipant_Max = nbrParticipant_Max;
		this.StartDate = startDate;
		this.EndDate = endDate;
	}



	public Long getIdEvenement() {
		return IdEvenement;
	}
	
	
	public void setIdEvenement(Long idEvenement) {
		IdEvenement = idEvenement;
	}
	public int getFee_supp() {
		return Fee_supp;
	}
	public void setFee_supp(int fee_supp) {
		Fee_supp = fee_supp;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getEventType() {
		return EventType;
	}
	public void setEventType(String eventType) {
		EventType = eventType;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public int getNbrParticipant_Max() {
		return NbrParticipant_Max;
	}
	public void setNbrParticipant_Max(int nbrParticipant_Max) {
		NbrParticipant_Max = nbrParticipant_Max;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	
    

}

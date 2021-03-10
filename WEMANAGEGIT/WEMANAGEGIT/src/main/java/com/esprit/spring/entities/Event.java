package com.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;




@Entity
public class Event implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
	
	@Column(name="Event_title")
	private String title;
	
	@Column(name="Event_Description")
    private String Description;
	
    @NotNull
    @Column(name="Event_Type")
    @Enumerated(EnumType.STRING)
    
    private EventType eventType;
    
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
    
    
    
    /*@OneToMany(mappedBy = "event")  
    List<EventParticipants> eventParticipants;
	
    @ManyToOne  
    public Garden getGarden() {
    	return garden;
    }*/


	public Event() {
		super();
	}
	


	public Event(Long id, String title, String description, @NotNull EventType eventType, int fee_supp,
			String designation, int nbrParticipant_Max, Date startDate, Date endDate) {
		super();
		Id = id;
		this.title = title;
		Description = description;
		this.eventType = eventType;
		Fee_supp = fee_supp;
		Designation = designation;
		NbrParticipant_Max = nbrParticipant_Max;
		StartDate = startDate;
		EndDate = endDate;
	}



	public Event(int fee_supp, @NotNull @Size(min = 20) String description, @NotNull EventType eventType,
			@NotNull String designation,
			@NotNull(message = "you should defined the max number of the participants") int nbrParticipant_Max,
			Date startDate, Date endDate) {
		super();
		this.Fee_supp = fee_supp;
		this.Description = description;
		this.eventType= eventType;
		this.Designation = designation;
		this.NbrParticipant_Max = nbrParticipant_Max;
		this.StartDate = startDate;
		this.EndDate = endDate;
	}



	
	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
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
	
	public EventType getEventType() {
		return eventType;
	}



	public void setEventType(EventType eventType) {
		this.eventType = eventType;
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



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	
    

}

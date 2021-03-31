package com.esprit.spring.entities;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;







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
	

	@Column(name="Event_Photo")
    private String photo;
	@Column(name="Fee_supp")
	private int Fee_supp;
	
    @NotNull
    @Column(name="Event_Type")
    @Enumerated(EnumType.STRING)
    
    
    private EventType eventType;
    
    @NotNull
    @Column(name="Event_Etat")
    @Enumerated(EnumType.STRING)
	private EventEtat eventEtat;
    
    @NotNull
    @Column(name="Event_Category")
    @Enumerated(EnumType.STRING)
	private EventCategory category;
 
	public int getNbr_participants() {
		return nbr_participants;
	}



	public void setNbr_participants(int nbr_participants) {
		this.nbr_participants = nbr_participants;
	}




	@Column(name="Event_Nbr_Participants")
	private int nbr_participants; 
	
	@Column(name="Event_invites")
	private int nbr_invites;
   
  
    @Temporal (TemporalType.DATE)
	@Column(name="Event_Date")
	private Date date_event;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="Event_StartDate")
	private java.sql.Time StartDate ;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
	@Column(name="Event_EndDate")
	private java.sql.Time EndDate ;
    
    @ManyToOne
private	Jdf kindergartenevent; 
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="events")
	private List <EventGallery> Galleryevents;
    /*@OneToMany(mappedBy = "event")  
    List<EventParticipants> eventParticipants;*/
    
    @JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy="EventInvitation")
	private  List<EventParticipantsInvitation> invitations;
	
   


	public List<EventParticipantsInvitation> getInvitations() {
		return invitations;
	}



	public void setInvitations(List<EventParticipantsInvitation> invitations) {
		this.invitations = invitations;
	}



	public Event() {
		super();
	}



	public Long getId() {
		return Id;
	}



	public void setId(Long id) {
		Id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}



	public int getFee_supp() {
		return Fee_supp;
	}



	public void setFee_supp(int fee_supp) {
		Fee_supp = fee_supp;
	}



	public EventType getEventType() {
		return eventType;
	}



	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}



	public EventEtat getEventEtat() {
		return eventEtat;
	}



	public void setEventEtat(EventEtat eventEtat) {
		this.eventEtat = eventEtat;
	}



	public EventCategory getCategory() {
		return category;
	}



	public void setCategory(EventCategory category) {
		this.category = category;
	}



	



	public int getNbr_invites() {
		return nbr_invites;
	}



	public void setNbr_invites(int nbr_invites) {
		this.nbr_invites = nbr_invites;
	}



	public Date getDate_event() {
		return date_event;
	}



	public void setDate_event(Date date_event) {
		this.date_event = date_event;
	}



	public java.sql.Time getStartDate() {
		return StartDate;
	}



	public void setStartDate(java.sql.Time startDate) {
		StartDate = startDate;
	}



	public java.sql.Time getEndDate() {
		return EndDate;
	}



	public void setEndDate(java.sql.Time endDate) {
		EndDate = endDate;
	}



	public Jdf getKindergartenevent() {
		return kindergartenevent;
	}



	public void setKindergartenevent(Jdf kindergartenevent) {
		this.kindergartenevent = kindergartenevent;
	}



	public List<EventGallery> getGalleryevents() {
		return Galleryevents;
	}



	public void setGalleryevents(List<EventGallery> galleryevents) {
		Galleryevents = galleryevents;
	}



	public Event(Long id, String title, String description, String photo, int fee_supp, @NotNull EventType eventType,
			@NotNull EventEtat eventEtat, @NotNull EventCategory category, int nbr_participants,
			 int nbr_invites, Date date_event, Time startDate, Time endDate,
			Jdf kindergartenevent, List<EventGallery> galleryevents, List<EventParticipantsInvitation> invitations) {
		super();
		this.Id = id;
		this.title = title;
		this.Description = description;
		this.photo = photo;
		this.Fee_supp = fee_supp;
		this.eventType = eventType;
		this.eventEtat = eventEtat;
		this.category = category;
		this.nbr_participants = nbr_participants;
		this.nbr_invites = nbr_invites;
		this.date_event = date_event;
		this.StartDate = startDate;
		this.EndDate = endDate;
		this.kindergartenevent = kindergartenevent;
		Galleryevents = galleryevents;
		this.invitations = invitations;
	}



	


	/*
	 * public Event(Long id, String title, String description, @NotNull EventType
	 * eventType, int fee_supp, String designation, int nbrParticipant_Max, Date
	 * startDate, Date endDate) { super(); Id = id; this.title = title; Description
	 * = description; this.eventType = eventType; Fee_supp = fee_supp; Designation =
	 * designation; NbrParticipant_Max = nbrParticipant_Max; StartDate = startDate;
	 * EndDate = endDate; }
	 * 
	 * 
	 * 
	 * public Event(int fee_supp, @NotNull @Size(min = 20) String
	 * description, @NotNull EventType eventType,
	 * 
	 * @NotNull String designation,
	 * 
	 * @NotNull(message = "you should defined the max number of the participants")
	 * int nbrParticipant_Max, Date startDate, Date endDate) { super();
	 * this.Fee_supp = fee_supp; this.Description = description; this.eventType=
	 * eventType; this.Designation = designation; this.NbrParticipant_Max =
	 * nbrParticipant_Max; this.StartDate = startDate; this.EndDate = endDate; }
	 */


	




	
    

}

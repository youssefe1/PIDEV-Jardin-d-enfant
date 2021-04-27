package com.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Event;
import com.esprit.spring.entities.EventCategory;
import com.esprit.spring.entities.EventEtat;
import com.esprit.spring.entities.EventType;
import com.esprit.spring.entities.Pk;


@Repository
public interface IEventRepository extends CrudRepository<Event, Long> {

	  Iterable<Event> findAll(Sort sort);

	  Page<Event> findAll(Pageable pageable);
	  
	  @Query("FROM Event ORDER BY date_event ASC")
	    List<Event> findAllOrderByDateAsc();
	  

	  @Query("FROM Event ORDER BY date_event ASC")
	    List<Event> getAllNameParticipate(Pk pk,String FirstName,String LastName);
	  @Query("SELECT e.title , e.category, e.date_event  FROM Event e where e.category=:categorie")
	    public List<String> listeventbycategory(@Param("categorie") EventCategory categorie);
	  @Query("SELECT e from Event e where e.date_event   = CURRENT_DATE()")
		 public Event getEventoftoday();
	  @Query("SELECT e FROM Event e where e.date_event   =:date ")
	    public Event findeventsbydate(@Param("date")Date date);
	  @Query("Select e FROM Event  e where e.date_event  = CURRENT_DATE() ")
		 public List<Event> eventtodayverifetat();
		 
		 @Query("Select e FROM Event  e where e.date_event   > CURRENT_DATE() ")
		 public List<Event> eventupcomingverifetat();
		 
		 @Query("Select e FROM Event  e where e.date_event  < CURRENT_DATE() ")

		 public List<Event> eventpassedverifetat();
		 
		 @Query("SELECT e FROM Event e where e.eventType =:type and e.eventEtat=:etat and e.category=:category")
		    public List<Event> filtredevents(@Param("type")EventCategory categorie,@Param("etat")EventType type,@Param("category")EventEtat etat);
}

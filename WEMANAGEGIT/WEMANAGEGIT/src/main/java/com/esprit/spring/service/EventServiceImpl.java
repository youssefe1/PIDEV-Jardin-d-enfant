package com.esprit.spring.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.Event;
import com.esprit.spring.entities.EventCategory;
import com.esprit.spring.entities.EventEtat;
import com.esprit.spring.entities.EventGallery;
import com.esprit.spring.entities.EventType;

import com.esprit.spring.repository.IEventRepository;
import com.esprit.spring.repository.IGalleryRepository;
import com.esprit.spring.service.IEventInvitationService;
import com.esprit.spring.service.IEventSerivce;






@Service
public class EventServiceImpl implements IEventSerivce {
	
	@Autowired
	IEventRepository eventrepository ;
	@Autowired
	IGalleryRepository galerierepository ;
	@Autowired
	IEventInvitationService EventInvitation;
	
	

	@Override
	public Iterable<Event> getAllEvent(int offset, int limit) {
		return (Iterable<Event>) eventrepository.findAll(PageRequest.of(offset, limit));
	}

	@Override
	public Event getEventById(Long Id) {
		return eventrepository.findById(Id).orElse(null);
	}

	@Override
	public Event addEvent(Event e) {
		
		 return eventrepository.save(e);
		
	}

	@Override
	public Event updateEvent(Long Id,Event e) {
		e.setId(Id);	       
        return eventrepository.save(e);
	}
	



	@Override
	public Event getEventByDate(Date date) {
		return eventrepository.findeventsbydate(date);
	}

	/*@Override
	public Event addEvent(Event e) {
		// TODO Auto-generated method stub
		return null;
	}*/

	

	@Override
	public Event deleteEventById(Long Id) {
		 Event event=eventrepository.findById(Id).orElse(null);
	       
	        eventrepository.deleteById(Id);
	        return event;
	}
	

	public List<Event> findAllOrderByDateAsc(){
		return eventrepository.findAllOrderByDateAsc();
	}

	@Override
	public List<String> getAllEventByCategorie(EventCategory categorie) {
		return eventrepository.listeventbycategory(categorie);
	}

	@Override
	public Event getEventoftoday() {
		
		return eventrepository.getEventoftoday();
	}

	@Override
	@Scheduled(cron = "0 * * * * ?")
	public void verifier_etat_event() {
	//LocalDateTime now = LocalDateTime.now();  
		Date date = new Date();
		   LocalDateTime now = LocalDateTime.now(); 
		  List<Event> events = eventrepository.findAllOrderByDateAsc();
		  for (int i=0;i<events.size();i++) {
			  if (events.get(i).getStartDate().after(date )) {
				  events.get(i).setEventEtat(EventEtat.a_venir);
			  }
			  
			  if ((events.get(i).getStartDate().equals(date))){
				  events.get(i).setEventEtat(EventEtat.en_cours);
			  }
			   eventrepository.save(events.get(i));
			   
		}
		
		
	}
	
	@Scheduled(cron = "0 * * * * ?")
	public void verfieretatevents(){
		List<Event> listtoday = eventrepository.eventtodayverifetat();
		List<Event> listupcom = eventrepository.eventupcomingverifetat();
		List<Event> listpassed = eventrepository.eventpassedverifetat();
		
		for (int i=0;i<listupcom.size();i++){
			listupcom.get(i).setEventEtat(EventEtat.a_venir);
		}
		eventrepository.saveAll(listupcom);
		
		for (int i=0;i<listtoday.size();i++){
			listtoday.get(i).setEventEtat(EventEtat.en_cours);
		}
		eventrepository.saveAll(listtoday);

		
		for (int i=0;i<listpassed.size();i++){
			listpassed.get(i).setEventEtat(EventEtat.terminé);
		}
		eventrepository.saveAll(listpassed);

	}

	@Override
	public Event geteventbyid(long Id) {
		return eventrepository.findById((long) Id).get();
	}

	

	@Override
	public List<Event> filterevents(EventCategory categorie, EventType type, EventEtat etat) {
		List<Event> filtredevents = eventrepository.filtredevents(categorie,type, etat);
		return filtredevents ;
	}

	@Override
	public void addimageevent(Long Id, String image, Date date) {
		 Date datee = new Date();
			Event e = eventrepository.findById(Id).get();

		 EventGallery gal = new EventGallery();
		 gal.setEvents(e);
		 gal.setImage(image);
		 gal.setDatepost(datee);
		galerierepository.save(gal);
		
	}

	@Override
	public List<EventGallery> listimagesevent(Long Id) {
		Event e = eventrepository.findById(Id).get();

		return galerierepository.listgalerieevent(e);
	};
	


}
package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.spring.entities.Event;
import com.esprit.spring.entities.EventGallery;


public interface IGalleryRepository extends CrudRepository<EventGallery,Long> {
	
	@Query("Select g from EventGallery g where g.events=:event")
	public List<EventGallery> listgalerieevent(@Param("event")Event event);

} 

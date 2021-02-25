package com.esprit.WEMANAGE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.WEMANAGE.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}

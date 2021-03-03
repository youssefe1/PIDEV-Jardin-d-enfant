package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Event;

@Repository
public interface IEventRepository extends JpaRepository<Event, Long> {

}

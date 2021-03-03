package com.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Bus;

@Repository
public interface IBusRepository  extends JpaRepository<Bus, Long> {
	
	 public List<Bus> getAllBusById(long IdBus) ;
	
     public int countBus();
	 Optional<Bus> findById( long IdBus );
	
	public Bus getBusById(long IdBus) ;

}

package com.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Bus;

@Repository
public interface IBusRepository  extends JpaRepository<Bus, Long> {
	
	@Query("SELECT b FROM Bus b where b.Id=?1")
	public List<Bus> getAllBusById(long Id) ;
	
  
	 Optional<Bus> findById( long Id );
	 @Query("SELECT b FROM Bus b where b.Id=?1")
	public Bus getBusById(long Id) ;

	 @Query("SELECT count(*) FROM Bus")
	    public int countBus();

}

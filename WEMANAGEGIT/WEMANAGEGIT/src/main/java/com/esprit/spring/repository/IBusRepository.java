package com.esprit.spring.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Bus;

@Repository
public interface IBusRepository  extends JpaRepository<Bus, Long> {
	
	@Query("SELECT b FROM Bus b where b. matricule=?1")
	 public Bus getBus(Long  matricule);
	
	@Query("SELECT b FROM Bus b where b. matricule=?1")
	public List<Bus> getAllBusById(long  matricule) ;
	
  
	 Optional<Bus> findById( long Id );
	 @Query("SELECT b FROM Bus b where b. matricule=?1")
	public Bus getBusById(long  matricule) ;

	 @Query("SELECT count(*) FROM Bus")
	    public int countBus();
	 @Query("select seatCapacity from Bus b where  matricule=?1")
		int findSeatCapacityByBusId(Integer  matricule);
	 //@Query("UPDATE  count(*) FROM Bus")
	//public Bus trajet(Long matricule);
	 
	 
}
package com.esprit.spring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.esprit.spring.exception.BusExistsException;
import com.esprit.spring.exception.BusNotFoundException;
import com.esprit.spring.entities.Bus;
import com.esprit.spring.entities.Pk;
import com.esprit.spring.repository.IBusRepository;
import com.esprit.spring.service.IBusService;

@Service
public class BusServiceImpl implements IBusService {
	
	@Autowired
    IBusRepository busRepository;

	@Override
	public List<Bus> getAllBus() {
		return (List<Bus>) busRepository.findAll();
	}

	@Override
	
	public Bus getBusById(Long  matricule) {
		
		if (!busRepository.existsById( matricule)) {
			throw new BusNotFoundException(" Bus not found");
		}
		return busRepository.getBus( matricule);
	}
	
	public Bus addBus(Bus B) {
		if(busRepository.existsById(B.getMatricule())) {
			 throw new BusExistsException("Bus Already Exits");
		  }
		return busRepository.save(B);
	}

	@Override
	public void deleteBus(Long  matricule) {
		if(!busRepository.existsById( matricule)) {
			 throw new BusNotFoundException("Bus Id with "+ matricule+" is NOT FOUND");
		 }
		Bus B = busRepository.findById((Long)  matricule).get();
		busRepository.deleteById(matricule);
		
	}

	@Override
	public Bus updateBus(Long matricule, Bus B) {
		B.setMatricule( matricule);
		return busRepository.save(B);
	}

	@Override
	public int getSeatCapacity() {
		return busRepository.countBus();
	}
	/*
	  @Override public double trajet(String latStart, String lonStart, String
	  latArrival, String lonArrival) { 
		 
			    final int R = 6371; //

			    double latDistance = Math.toRadians(Double.parseDouble(latArrival) - Double.parseDouble(latStart));
			    double lonDistance = Math.toRadians(Double.parseDouble(lonArrival) - Double.parseDouble(lonStart));
			    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
			            + Math.cos(Math.toRadians(Double.parseDouble(latStart))) * Math.cos(Math.toRadians(Double.parseDouble(latArrival)))
			            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
			    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
			    double distance = R * c * 1000; // convert to meters

			    distance = Math.pow(distance, 2) ;

			    return Math.sqrt(distance);
	  }*/

	  @Override public double trajet(Long  matricule) { 
		 
			Bus B = busRepository.getBusById( matricule);

		    final int R = 6371; //

		    double latDistance = Math.toRadians(Double.parseDouble(B.getLatArrival()) - Double.parseDouble(B.getLatStart()));
		    double lonDistance = Math.toRadians(Double.parseDouble(B.getLonArrival()) - Double.parseDouble(B.getLonStart()));
		    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
		            + Math.cos(Math.toRadians(Double.parseDouble(B.getLatStart()))) * Math.cos(Math.toRadians(Double.parseDouble(B.getLatArrival())))
		            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		    double distance = R * c * 1000; // convert to meters

		    distance = Math.pow(distance, 2) ;

		    return Math.sqrt(distance);
  }
	  
}
	  
	 /* @Override public Bus trajet(Long  matricule) { 
			 
			Bus B = busRepository.getBusById( matricule);

		    final int R = 6371; //

		    double latDistance = Math.toRadians(Double.parseDouble(B.getLatArrival()) - Double.parseDouble(B.getLatStart()));
		    double lonDistance = Math.toRadians(Double.parseDouble(B.getLonArrival()) - Double.parseDouble(B.getLonStart()));
		    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
		            + Math.cos(Math.toRadians(Double.parseDouble(B.getLatStart()))) * Math.cos(Math.toRadians(Double.parseDouble(B.getLatArrival())))
		            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		    double distance = R * c * 1000; // convert to meters

		    distance = Math.pow(distance, 2) ;
		    B.setTrajet(17);

		    return busRepository.trajet(matricule);*/

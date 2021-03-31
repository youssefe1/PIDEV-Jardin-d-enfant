package com.esprit.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entities.Bus;

import com.esprit.spring.entities.EventParticipantsInvitation;
import com.esprit.spring.repository.IBusRepository;


import com.esprit.spring.service.IBusService;

@RestController
public class BusRestControllerImpl {
	@Autowired
    IBusService busservice;
 
 @Autowired
 	IBusRepository BusR;
 
 @GetMapping("/getAllBus")
 @ResponseBody
 public ResponseEntity<List<Bus>> getAllBus(){
	 List<Bus> allBuses = busservice.getAllBus();
	 return new ResponseEntity<List<Bus>>(allBuses, HttpStatus.OK);
 }

 @GetMapping("/{matricule}")
	public ResponseEntity<Bus> getBusById(@PathVariable Long  matricule) {

		Bus B = busservice.getBusById( matricule);

		return new ResponseEntity<Bus>(B, HttpStatus.OK);
	}
 
 
 @PostMapping("/addBus")
 @ResponseBody
 public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus B){
	busservice.addBus(B);
	return new ResponseEntity<Bus>(B, HttpStatus.CREATED);
 }
 
 

 
 @DeleteMapping("/deleteBus/{ matricule}")
 @ResponseBody
 public ResponseEntity<Bus> deleteBus(@Valid @PathVariable(" matricule") Long  matricule){
	 busservice.deleteBus( matricule);
	 return new ResponseEntity<Bus>(HttpStatus.OK);
 }
 
 @PutMapping("/updatebus/{ matricule}")
 @ResponseBody
 public Bus updateBus(@PathVariable(" matricule") Long  matricule,@RequestBody Bus B){
	return busservice.updateBus( matricule,B);
 }
 
 @GetMapping("/SeatCapacity")
 @ResponseBody
 public int getNbrPlaceDispo(){
	 EventParticipantsInvitation e = new EventParticipantsInvitation();
	 
	  return busservice.getSeatCapacity();
 }
 
 @GetMapping("/calcul/{matricule}")
 public double trajet(@PathVariable("matricule") Long  matricule)  {
		Bus B = busservice.getBusById(matricule);

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

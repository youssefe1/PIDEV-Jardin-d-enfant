package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entities.Bus;
import com.esprit.spring.entities.Event;
import com.esprit.spring.repository.IBusRepository;
import com.esprit.spring.repository.IEventRepository;
import com.esprit.spring.service.BusServiceImpl;
import com.esprit.spring.service.EventServiceImpl;
import com.esprit.spring.service.IBusService;

@RestController
public class BusRestControllerImpl {
	@Autowired
    IBusService busservice;
 
 @Autowired
 	IBusRepository BusR;
 
 @GetMapping("/getBus")
 @ResponseBody
 public List<Bus> getAllBus(){
	  return busservice.getAllBus();
 }
 
 
 @PostMapping("/addBus")
 @ResponseBody
 public Bus addBus(@RequestBody Bus B){
	return busservice.addBus(B);
 }
 
 

 @DeleteMapping("/deleteBus/{Id}")
 @ResponseBody
 public void deleteBus(@PathVariable("Id") Long Id){
	 busservice.deleteBus(Id);
 }
 
 @PutMapping("/updatebus/{id}")
 @ResponseBody
 public Bus updateBus(@RequestBody Bus B){
	return busservice.updateBus(B);
 }
	
@GetMapping("/NbrPlace")
 @ResponseBody
 public int getNbrPlaceDispo(){
	  return busservice.getNbrPlaceDispo();
 }
 


}

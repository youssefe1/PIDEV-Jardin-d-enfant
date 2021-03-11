package com.esprit.spring.service;

import java.util.List;

import com.esprit.spring.entities.Bus;

public interface IBusService {
	List<Bus> getAllBus(); 
	public Bus addBus(Bus B);
	public void deleteBus(Long Id);
	Bus updateBus(Bus B);
	//public int getNbrPlaceDispo();
	

}

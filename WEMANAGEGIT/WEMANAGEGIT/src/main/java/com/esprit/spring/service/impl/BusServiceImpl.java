package com.esprit.spring.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.Bus;
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
	
	public Bus addBus(Bus B) {
		return busRepository.save(B);
	}

	@Override
	public void deleteBus(Long Id) {
		Bus B = busRepository.findById((Long) Id).get();
		busRepository.deleteById(Id);
		
	}

	@Override
	public Bus updateBus(Bus B) {
		return busRepository.save(B);
	}

	/*@Override
	public int getNbrPlaceDispo() {
		return busRepository.countBus();
	}*/

	

}

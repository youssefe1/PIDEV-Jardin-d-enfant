package com.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.Bus;
import com.esprit.spring.repository.IBusRepository;

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
	public void deleteBus(Long IdBus) {
		Bus B = busRepository.findById((long) IdBus).get();
		busRepository.deleteById(IdBus);
		
	}

	@Override
	public Bus updateBus(Bus B) {
		return busRepository.save(B);
	}

	@Override
	public int getNbrPlaceDispo() {
		return busRepository.countBus();
	}

	

}

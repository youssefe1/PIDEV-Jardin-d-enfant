package com.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.JDF;
import com.esprit.spring.repository.IJDFRepository;



@Service
public class JDFService implements IJDFService {
	
	@Autowired
    IJDFRepository ijdfrepository;
   

   
   
   
   @Override
   public Long ajouterjdf(JDF jdf)	{
	   return ijdfrepository.save(jdf).getId();
   }
   
	public List<JDF> listjdf(){
		return (List<JDF>) ijdfrepository.findAll();
		
	}
	public void deleteJdfById(Long ide){
		JDF n = ijdfrepository.findById(ide).get();
		ijdfrepository.delete(n);
		
	}
	
	public void mettreAjourJDFById(JDF jdf, Long id){
		
	}
	


}

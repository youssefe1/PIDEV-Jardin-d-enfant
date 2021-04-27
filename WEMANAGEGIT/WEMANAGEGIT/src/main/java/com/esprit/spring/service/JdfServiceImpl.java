package com.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.Jdf;
import com.esprit.spring.entities.Message;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.IJdfRepository;
import com.esprit.spring.repository.IMessageRepository;
import com.esprit.spring.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class JdfServiceImpl implements IJdfService{

	
	private static Logger logger = LoggerFactory.getLogger(JdfServiceImpl.class);

	@Autowired
	IJdfRepository JdfR ;
	@Autowired
	UserRepository usrR;

	@Override
	public Long ajouterJDF(Jdf jdf) {
		return JdfR.save(jdf).getId();
	}
	

	
	
	@Override
	public List<Jdf> listjdf() {
		return (List<Jdf>) JdfR.findAll();

	}




	@Override
	public void deleteJDFById(Long ide) {
		Jdf jdf  =  JdfR.findById(ide).get();
		JdfR.delete(jdf);		
	}




	@Override
	public void mettreAjourDescriptionByJDFId(String description, Long id) {
		Jdf jdf = JdfR.findById(id).get();

		jdf.setDescription(description);

		JdfR.save(jdf);			
	}




	@Override
	public void affecterUserAJDF(User user,Jdf jdf) {
		// TODO Auto-generated method stub
		
	
		logger.info(" user: {}",
				"id user " + user.getId() + " user nom " + user.getLastName() + " user prenom " + user.getFirstName());


		if ( !(jdf.getUsers().contains(user))) {
			jdf.getUsers().add(user);
		}

		logger.info(" taille: {}", jdf.getUsers().size());

		JdfR.save(jdf);
		
	}




	@Override
	public  void affecterUsrAJDF(Long userid, Long jdfid) {
		User user = usrR.findById(userid).orElse(null);

		Jdf jdf = JdfR.findById(jdfid).orElse(null);

		jdf.getUsers().add(user);

		JdfR.save(jdf);		
	}




	@Override
	public Jdf listjdfById(Long id) {
		Jdf jdf =  JdfR.findById(id).get();
 		return jdf ;
	}
	
	

		


}

package com.esprit.spring.service;

import java.util.List;

import com.esprit.spring.entities.FeedBack;
import com.esprit.spring.entities.Jdf;
import com.esprit.spring.entities.User;

public interface IJdfService {

	public List<Jdf> listjdf();
	public void deleteJDFById(Long ide);
	public Long ajouterJDF(Jdf jdf);
	public void mettreAjourDescriptionByJDFId(String Body, Long id);
	public void affecterUserAJDF(User user, Jdf jdf);
	public void affecterUsrAJDF(Long userid, Long jdfid);


}

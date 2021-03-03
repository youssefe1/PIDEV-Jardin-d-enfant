package com.esprit.spring.service;

import java.util.List;

import com.esprit.spring.entities.FeedBack;;

public interface IFeedBackService {
	public List<FeedBack> listmessage();
	public void deleteFeedBackById(Long ide);
	public Long ajouterFeedBack(FeedBack feedback);
	public void mettreAjourFeedBackById(FeedBack feedback, Long id);

}

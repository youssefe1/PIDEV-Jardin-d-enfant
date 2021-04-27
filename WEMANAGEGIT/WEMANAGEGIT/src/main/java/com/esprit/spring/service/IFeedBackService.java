package com.esprit.spring.service;

import java.util.List;

import com.esprit.spring.entities.FeedBack;
import com.esprit.spring.entities.Jdf;
import com.esprit.spring.entities.Message;
import com.esprit.spring.entities.User;

public interface IFeedBackService {

	public List<FeedBack> listfeedback();
	public void deleteFeedbackById(Long ide);
	public Long ajouterFeedback(FeedBack feedback);

	public void mettreAjourNoteByFeedId(float note, Long id);
	public void affecterUsrAFeed(Long userid, Long feedid);
	public FeedBack listfeedById(Long id);
	public FeedBack ajouterFeedBack2(FeedBack feedBack,Long jdf_id);
}

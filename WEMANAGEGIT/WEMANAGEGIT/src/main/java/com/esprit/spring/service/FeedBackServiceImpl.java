package com.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.FeedBack;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.IFeedBackRepository;
import com.esprit.spring.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FeedBackServiceImpl implements IFeedBackService {


	private static Logger logger = LoggerFactory.getLogger(FeedBackServiceImpl.class);
	@Autowired
	IFeedBackRepository    feedR ;
	@Autowired
	UserRepository usrR;
	
	
	@Override
	public List<FeedBack> listfeedback() {
		return (List<FeedBack>) feedR.findAll();
	}

	@Override
	public void deleteFeedbackById(Long ide) {
		FeedBack feed = feedR.findById(ide).get();
		feedR.delete(feed);
	}

	@Override
	public Long ajouterFeedback(FeedBack feedback) {
		return feedR.save(feedback).getId();
	}

	@Override
	public void mettreAjourNoteByFeedId(float note, Long id) {
		FeedBack feed = feedR.findById(id).get();

		feed.setNote(note);
		feedR.save(feed);	
	}

	@Override
	public void affecterUsrAFeed(Long userid, Long feedid) {
		User user = usrR.findById(userid).orElse(null);

		FeedBack feed = feedR.findById(feedid).orElse(null);

		feed.getUsers().add(user);

		feedR.save(feed);	
	}
	
}

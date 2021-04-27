package com.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.FeedBack;
import com.esprit.spring.entities.Jdf;
import com.esprit.spring.entities.Message;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.IFeedBackRepository;
import com.esprit.spring.repository.IJdfRepository;
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
	@Autowired
	IJdfRepository jdfR ;
	
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

	@Override
	public FeedBack listfeedById(Long id) {
		// TODO Auto-generated method stub
		FeedBack fed =  feedR.findById(id).get();
 		return fed ;	}

	@Override
	public FeedBack ajouterFeedBack2(FeedBack feedBack, Long jdf_id) {
		Jdf jdf = jdfR.findById(jdf_id).get();
		feedBack.setJdf(jdf);
		 return feedR.save(feedBack);}
	
	
}

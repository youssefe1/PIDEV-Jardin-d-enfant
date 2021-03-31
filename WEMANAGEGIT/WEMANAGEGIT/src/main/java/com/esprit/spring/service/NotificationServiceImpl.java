package com.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.Message;
import com.esprit.spring.entities.Notification;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.INotificationRepository;
import com.esprit.spring.repository.IUserRepository;






@Service
public class NotificationServiceImpl implements INotificationService {
	@Autowired
	INotificationRepository NotR ;
	
	@Autowired
	IUserRepository usrR ;
	
	/*@Override
	public void ajouterNotification(Notification notification) {

		 NotR.save(notification);

	}*/
	@Override
	public Long ajouterNotif(Notification notification) {

		return NotR.save(notification).getId();

	}


	@Override
	public List<Notification> listnotif() {
		return (List<Notification>) NotR.findAll();

	}
	
	@Override
	public void deleteNotifById(Long ide) {
		Notification n= NotR.findById(ide).get();
		NotR.delete(n);		
	}


	@Override
	public void mettreAjourBodyByNotifId(String Body, Long id) {
		Notification notif = NotR.findById(id).get();

		notif.setBody(Body);

		NotR.save(notif);		
	}
	@Override
	public List<String> getAllNotifTrieJPQL() {
		return NotR.getAllNotifTrieJPQL();
	}


	@Override
	public Long getNombreNotification() {
		// TODO Auto-generated method stub
		return NotR.getnombreNotification();
	}

}

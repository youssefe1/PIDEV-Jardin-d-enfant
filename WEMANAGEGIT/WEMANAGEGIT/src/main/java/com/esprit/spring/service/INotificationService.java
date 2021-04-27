package com.esprit.spring.service;

import java.util.List;

import com.esprit.spring.entities.Notification;

public interface INotificationService {
	//public Long ajouterNotification(Notification notification);
	public List<Notification> listnotif();
	public Notification listnotifById(Long id);

	public void deleteNotifById(Long ide);
	//public void affecterMessageAUser(Long id , Long user_id);
	public Long ajouterNotif(Notification notification);
	public Notification ajouterNotif2(Notification notification,Long user_id);

	public void mettreAjourBodyByNotifId(String Body, Long id);
	public List<String> getAllNotifTrieJPQL();
	public Long getNombreNotification() ;

}

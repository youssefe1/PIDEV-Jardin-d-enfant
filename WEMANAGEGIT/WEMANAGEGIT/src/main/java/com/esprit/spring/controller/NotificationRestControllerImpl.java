package com.esprit.spring.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entities.Message;
import com.esprit.spring.entities.Notification;
import com.esprit.spring.repository.INotificationRepository;
import com.esprit.spring.service.INotificationService;


@RestController
public class NotificationRestControllerImpl {

	@Autowired
	INotificationService notificationService ;
	@Autowired 
	INotificationRepository notificationR ; 

	@PostMapping("/add-notif")
	@ResponseBody
	public void ajouterNotification(@RequestBody Notification notification) {

	 	notificationService.ajouterNotif(notification);

	}
	@GetMapping("/getnotifications")
	@ResponseBody
	public List<Notification> getNotif() {

		return notificationService.listnotif();
	}
	
	
	@DeleteMapping("/deleteNotifById/{id}")
	public void deleteNotifById(@PathVariable("id") Long ide) {
		notificationService.deleteNotifById(ide);
	}
	@PutMapping("/mettreAjourBodyByNotifId/{body}/{id}")
	@ResponseBody
	public void mettreAjourBodyByNotifId(@PathVariable("body") String body, @PathVariable("id") Long id) {

		notificationService.mettreAjourBodyByNotifId(body, id);

	}

    @GetMapping("/getNotificationTrier")
	@ResponseBody
	public List<String> getAllNotifTrieJPQL() {

		return notificationService.getAllNotifTrieJPQL();
	}
    @GetMapping("/getNombreNotificationJPQL")
	@ResponseBody
	public long getNombreNotification() {

		return notificationService.getNombreNotification();
	}

	
}

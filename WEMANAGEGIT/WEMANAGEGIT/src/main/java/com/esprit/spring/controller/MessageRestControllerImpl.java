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
import com.esprit.spring.repository.IMessageRepository;
import com.esprit.spring.service.IMessageService;



@RestController
public class MessageRestControllerImpl {
	@Autowired
	IMessageService messageService ; 
	@Autowired
	IMessageRepository messageR ;	
	/*
	private  Long Id;
	private String Body  ;
	private Date CreatedAt ;
	private Long user_id ;
	*/
	
	

	
	
	
	
	@PostMapping("/add-mes")
	@ResponseBody
	public void ajouterMessage(@RequestBody Message message) {

		 messageService.ajouterMessage(message);
		 
	}


	@GetMapping("/getmessages")
	@ResponseBody
	public List<Message> getMessage() {

		return messageService.listmessage();
	}
	
	
	@DeleteMapping("/deleteMessage/{id}")
	@ResponseBody
	public void deleteMessageById(@PathVariable("id") Long ide) {
		messageService.deleteMessageById(ide);
		}

	
	   @PutMapping("/edit/{id}")
	   @ResponseBody
	   public void editDep(@PathVariable Long id, @RequestBody Message message) {
	        messageR.save(message);
	    }	
	   
		@PutMapping("/mettreAjourBodyByMessageId/{body}/{id}")
		@ResponseBody
		public void mettreAjourBodyByMessageId(@PathVariable("body") String body, @PathVariable("id") Long id) {

			messageService.mettreAjourBodyByMessageId(body, id);

		}
	   
	   
	
}

package com.esprit.spring.service;

import java.util.List;
import com.esprit.spring.entities.Message;
import com.esprit.spring.entities.Notification;

public interface IMessageService {
	//public void ajouterMessage(Message message);
	public List<Message> listmessage();
	public void deleteMessageById(Long ide);
	public Long ajouterMessage(Message message);
	public void mettreAjourBodyByMessageId(String Body, Long id);
	public List<String> getAllMessageTrieJPQL();
	List<Message> retrieveHistory();
	Message addMessage(Message message);
	public Message listmessageById(Long id);
	public Message ajouterMessage2(Message message,Long user_id);



	
}

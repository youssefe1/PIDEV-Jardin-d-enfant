package com.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.esprit.spring.entities.Message;
import com.esprit.spring.entities.Notification;
import com.esprit.spring.repository.IMessageRepository;


@Service
public class MessageServiceImpl  implements IMessageService{

	
	
	@Autowired
	IMessageRepository MesR ;

	@Override
	public Long ajouterMessage(Message message) {
		return MesR.save(message).getId();
	}
	

	
	
	@Override
	public List<Message> listmessage() {
		return (List<Message>) MesR.findAll();

	}
/*
	@Override
	public void deleteMesageById(Long id) {
		Message m= MesR.findById(id).get();
		MesR.delete(m);				
	}
*/


	
	



@Override
public void deleteMessageById(Long ide) {
Message message =  MesR.findById(ide).get();
MesR.delete(message);
}




@Override
public void mettreAjourBodyByMessageId(String Body, Long id) {
	Message msg = MesR.findById(id).get();

	msg.setBody(Body);

	MesR.save(msg);	
}
	
	
}

package com.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.esprit.spring.entities.Message;
import com.esprit.spring.entities.Notification;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.IMessageRepository;
import com.esprit.spring.repository.IUserRepository;


@Service
public class MessageServiceImpl  implements IMessageService{

	
	
	@Autowired
	IMessageRepository MesR ;
	@Autowired
	IUserRepository usrR ;

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
@Override
public List<String> getAllMessageTrieJPQL() {
	return MesR.getAllMessageTrieJPQL();
}

@Autowired
IMessageRepository chatRepo;

@Override
public List<Message> retrieveHistory() {
	// TODO Auto-generated method stub
	return chatRepo.findHistory();
}

@Override
public Message addMessage(Message message) {
	// TODO Auto-generated method stub
	return chatRepo.save(message);
}




@Override
public Message listmessageById(Long id) {
	// TODO Auto-generated method stub
	Message mes =  MesR.findById(id).get();
 		return mes ;
 		}




@Override
public Message ajouterMessage2(Message message, Long user_id) {
	// TODO Auto-generated method stub
	User usr = usrR.findById(user_id).get();
	message.setSender(usr);	
	 return MesR.save(message);}

}






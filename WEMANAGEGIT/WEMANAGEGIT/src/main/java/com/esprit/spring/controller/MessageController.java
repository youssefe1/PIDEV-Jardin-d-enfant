package com.esprit.spring.controller;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.esprit.spring.entities.Message;
import com.esprit.spring.service.IMessageService;



@Controller
public class MessageController {
    @Autowired
    IMessageService chatService;
	
	@MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message chatMessagePojo) throws ParseException {
        Date date=new Date();
        int i=2;
        //long l=i;
        Long l2=Long.valueOf(i);

     // User s = new User(l2,"sfax","123","user",true,"@.g.com",54000000,"aaa","a","b");
        date.setHours(date.getHours()+1);
        chatMessagePojo.setDate(date);
       
      //  chatMessagePojo.setUser(s);
 //   chatMessagePojo.setUser_id(l2);

        
        
        
        
        // chatMessagePojo.setSender("h");
     //   chatMessagePojo.setType(ChatMessagePojo.MessageType.LEAVE);
        chatMessagePojo.getSender().setActive(false);
        return chatService.addMessage(chatMessagePojo);
        
    }

    @MessageMapping("/chat.getHistory")
    @SendTo("/topic/public")
    public List<Message> history(@Payload Message chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) throws ParseException {
    headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
    //chatMessagePojo.setType(Message.MessageType.JOIN);
    return chatService.retrieveHistory();
    }
    /*
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessagePojo addUser(@Payload ChatMessagePojo chatMessagePojo, SimpMessageHeaderAccessor headerAccessor) {
    headerAccessor.getSessionAttributes().put("username", chatMessagePojo.getSender());
    return chatMessagePojo;
    }*/
}

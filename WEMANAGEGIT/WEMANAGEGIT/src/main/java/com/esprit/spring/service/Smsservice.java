package com.esprit.spring.service;

import java.net.URI;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.esprit.spring.controller.Smsrequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@Service
public class Smsservice {

	private final Twilioproperties twilioproperties;
	
	@Autowired
	public Smsservice(Twilioproperties twilioproperties)
	{
		this.twilioproperties=twilioproperties;
	}
	
	
	//send message to number
	public String whatsup(Smsrequest smsrequest)
	{
        //note: 1. if you want to send normal text sms remove string ("whatsapp:") in below message creator
		//      2. if you want to send whatsapp message "whatsapp:" string to be added before the numbers
		Message message=Message.creator(new PhoneNumber("whatsapp:"+smsrequest.getNumber()), new PhoneNumber("whatsapp:"+twilioproperties.getFromNumber()), smsrequest.getMessage()).create();
        return message.getStatus().toString();
        
	
	}
	@Value("${app.twillio.accountSID}")
	private String ACCOUNT_SID;
	
	@Value("${app.twillio.authToken}")
	private String AUTH_TOKEN;
	
	
	public void sendSms(String to,String from,String body) {
		
		try {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator( new PhoneNumber(to), new PhoneNumber(from),body) // to:to which no  you want to send sms           
	            .setMediaUrl(Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))     // from: twillio given phone no
	            .setStatusCallback(URI.create("http://postb.in/1234abcd"))                      // body : text message
	            .create();

	        System.out.println(message);
	        System.out.println(message.getSid());

		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	
	


	public void makeCall(String from, String to) {
		
		try {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Call call = Call.creator(
	                new PhoneNumber(to),
	                new PhoneNumber(from),
	                URI.create("http://demo.twilio.com/docs/voice.xml"))
	            .setStatusCallback(URI.create("http://postb.in/1234abcd"))
	            .create();
	        System.out.println(call);
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	}
	}
	
	


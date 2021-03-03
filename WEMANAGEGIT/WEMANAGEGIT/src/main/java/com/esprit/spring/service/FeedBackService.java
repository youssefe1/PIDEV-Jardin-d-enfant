package com.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.repository.*;
import com.esprit.spring.security.SecurityConfig;

@Service
public class FeedBackService {
	
	@Autowired
    IFeedBackRepository ifeedbackrepository;
   
   @Autowired
    SecurityConfig securityConfig;

}

package com.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.service.FeedBackService;


@RestController
@RequestMapping("")
public class FeedBackController {
	
	 @Autowired
	    FeedBackService feedbackservice;

}

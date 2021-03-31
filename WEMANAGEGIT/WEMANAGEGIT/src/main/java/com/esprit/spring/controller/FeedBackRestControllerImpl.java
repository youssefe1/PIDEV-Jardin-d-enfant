package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entities.FeedBack;
import com.esprit.spring.entities.Jdf;
import com.esprit.spring.repository.IFeedBackRepository;
import com.esprit.spring.repository.IJdfRepository;
import com.esprit.spring.service.IFeedBackService;
import com.esprit.spring.service.IJdfService;

@RestController
public class FeedBackRestControllerImpl {

	
	@Autowired
	IFeedBackService feedService ; 
	@Autowired
	IFeedBackRepository feedR ;	
	
	@PostMapping("/add-feed")
	
	public void ajouterJDF(@RequestBody FeedBack feedback) {

		 feedService.ajouterFeedback(feedback);
		 
		 
	}


	@GetMapping("/getfeed")
	@ResponseBody
	public List<FeedBack> getFeedback() {

		return feedService.listfeedback();
	}
	
	
	@DeleteMapping("/deleteFeed/{id}")
	@ResponseBody
	public void deleteFeedById(@PathVariable("id") Long ide) {
		feedService.deleteFeedbackById(ide);
		}

	
	   @PutMapping("/editfeed/{id}")
	   @ResponseBody
	   public void editDep(@PathVariable Long id, @RequestBody FeedBack feed) {
	        feedR.save(feed);
	    }	
	   
	   
		@PutMapping("/mettreAjourNoteByFeedId/{note}/{id}")
		@ResponseBody
		public void mettreAjourNoteByFeedId(@PathVariable("note") Float note, @PathVariable("id") Long id) {

			feedService.mettreAjourNoteByFeedId(note, id);

		}
	




		@PostMapping("/affecter-user-feedback/{userid}/{feedid}")
		@ResponseBody
		public void affecterUsrAFeed(@PathVariable("userid") Long userid, @PathVariable("feedid") Long feedid) {

			feedService.affecterUsrAFeed(userid,feedid);
		}


}

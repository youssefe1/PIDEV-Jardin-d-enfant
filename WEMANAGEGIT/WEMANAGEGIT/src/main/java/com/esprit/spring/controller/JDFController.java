package com.esprit.spring.controller;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.esprit.spring.repository.IJDFRepository;
import com.esprit.spring.service.JDFService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.esprit.spring.entities.JDF;


@RestController
@RequestMapping("")
public class JDFController {
	
	 @Autowired
	    JDFService jdfservice;
	 
	 @Autowired
	 	IJDFRepository jdfR;
	 
	 
	 @PostMapping("/addjdf")
	 @ResponseBody
	 public void ajouterJDF(@RequestBody JDF jdf){
		 jdfservice.ajouterjdf(jdf);
	 }
	 
	 @GetMapping("/getJDF")
	 @ResponseBody
	 public List<JDF> getJDF(){
		 return jdfservice.listjdf();
	 }
	 
	 @DeleteMapping("/deleteJDF/{id}")
	 public void deleteJDF(@PathVariable("id") Long ide){
		 jdfservice.deleteJdfById(ide);
	 }
	 
	 @PutMapping("/editjdf/{id}")
	 @ResponseBody
	 public void updateJDF(@PathVariable("id") Long id,@RequestBody JDF jdf){
		 jdfservice.mettreAjourJDFById(jdf, id);
	 }
}

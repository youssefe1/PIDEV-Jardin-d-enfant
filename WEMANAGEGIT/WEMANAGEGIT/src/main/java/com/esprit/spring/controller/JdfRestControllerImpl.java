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

import com.esprit.spring.entities.Jdf;
import com.esprit.spring.entities.Message;
import com.esprit.spring.repository.IJdfRepository;
import com.esprit.spring.service.IJdfService;
import com.esprit.spring.service.JdfServiceImpl;


@RestController
public class JdfRestControllerImpl {
	
	@Autowired
	IJdfService jdfService ; 
	@Autowired
	IJdfRepository jdfR ;	
	
	@PostMapping("/add-jdf")
	@ResponseBody
	public void ajouterJDF(@RequestBody Jdf jdf) {

		 jdfService.ajouterJDF(jdf);
		 
	}


	@GetMapping("/getjdf")
	@ResponseBody
	public List<Jdf> getMessage() {

		return jdfService.listjdf();
	}
	
	
	@DeleteMapping("/deleteJDF/{id}")
	@ResponseBody
	public void deleteJDFById(@PathVariable("id") Long ide) {
		jdfService.deleteJDFById(ide);
		}

	
	   @PutMapping("/editjdf/{id}")
	   @ResponseBody
	   public void editDep(@PathVariable Long id, @RequestBody Jdf jdf) {
	        jdfR.save(jdf);
	    }	
	   
		@PutMapping("/mettreAjourDescriptionByJDFId/{description}/{id}")
		@ResponseBody
		public void mettreAjourDescriptionByJDFId(@PathVariable("description") String description, @PathVariable("id") Long id) {

			jdfService.mettreAjourDescriptionByJDFId(description, id);

		}
		@PostMapping("/affecterUserJardin")
		@ResponseBody
		public void affecterUserAJDF(@RequestBody Jdf jdf) {

			jdfService.affecterUserAJDF(jdf.getUsers().get(0), jdf);

		}




		@PostMapping("/affecter-user-jdf/{userid}/{jdfid}")
		@ResponseBody
		public void affecterUsrAJDF(@PathVariable("userid") Long userid, @PathVariable("jdfid") Long jdfid) {

			jdfService.affecterUsrAJDF(userid,jdfid);
		}


	    @GetMapping("/getJDF/{id}")
	   	@ResponseBody
	   	public Jdf listjdfById(@PathVariable("id") Long id) {
	    	Jdf jdf = jdfService.listjdfById(id);
	   		return jdf ;
	   	
	   	}






}

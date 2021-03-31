package com.esprit.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	 @RequestMapping("/chat")
	    public String index(HttpServletRequest request, Model model) {
	        return "index2";
	    }

}

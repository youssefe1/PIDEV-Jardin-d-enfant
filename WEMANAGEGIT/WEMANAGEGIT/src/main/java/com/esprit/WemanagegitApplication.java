package com.esprit;

import java.security.Principal;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

@SpringBootApplication
public class WemanagegitApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WemanagegitApplication.class, args);
	}
	

}

package com.esprit;


import org.springframework.boot.SpringApplication;
import java.io.File;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.esprit.spring.controller.FileUploadController;


@SpringBootApplication
public class WemanagegitApplication {
	
	public static void main(String[] args) {
		new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(WemanagegitApplication.class, args);
	}
	

}

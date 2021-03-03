package com.esprit.spring.security;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.esprit.spring.entities.User;
import com.esprit.spring.repository.IUserRepository;
import com.esprit.spring.service.MyUserService;




@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	    IUserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(getUserDetailsService());
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	http.cors().and().csrf().disable().authorizeRequests()
	       
	                .antMatchers("/user/add").permitAll()
	                .antMatchers("/users").permitAll()
	                .antMatchers("/admin/add").hasRole("ADMIN")
	                .antMatchers("/user/{id}/delete").permitAll()
	                .and().httpBasic();
	    }


	    @Bean
	    public UserDetailsService getUserDetailsService() {
	        return new MyUserService();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }


	    // If the User table is empty it will be initialized with a user
	/*    @PostConstruct
	    public void init(){
	        if (userRepository.findAll().size()==0){
	            User user = new User();
	            user.setRoles("ADMIN");
	         
	            user.setEmail("youssef.darderi@esprit.tn");
	            user.setActive(true);
	            user.setUserName("youssef");
	            user.setPassword(passwordEncoder.encode("admin"));
	            
	            userRepository.save(user);
	        }
	    }*/
}



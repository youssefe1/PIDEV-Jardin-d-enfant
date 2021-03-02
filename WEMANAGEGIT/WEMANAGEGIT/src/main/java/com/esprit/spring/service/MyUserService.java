package com.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.esprit.spring.entities.*;
import com.esprit.spring.repository.IUserRepository;
import com.esprit.spring.security.SecurityConfig;




@Service
public  class MyUserService implements UserDetailsService{

	   @Autowired
	    IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

	
	 
}

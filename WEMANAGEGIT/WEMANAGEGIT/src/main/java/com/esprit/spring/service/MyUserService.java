package com.esprit.spring.service;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.*;

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
	   
	   @Autowired
	    SecurityConfig securityConfig;

	@Override
	 public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user= userRepository.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("No user with the username "+userName));
        // return user.map(MyUserDetails ::new).get();
        return new MyUserDetails(user.get());
    }
	
	public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user) throws Exception {
        if (userRepository.findByUserName(user.getUserName()).isPresent()) throw new Exception("This " +
                "username " +
                "already exist");
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        user.setRoles("ROLE_USER");
        user.setActive(true);
        return userRepository.save(user);
    }
   
    public User addAdmin(User user) throws Exception {
        if (userRepository.findByUserName(user.getUserName()).isPresent()) throw new Exception("This username " +
                "already exist");
        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
        user.setRoles("ROLE_ADMIN");
        user.setActive(true);
        return userRepository.save(user);
    }

   
    public User deleteUser(Long userId) {
        User utl=
                userRepository.findById(userId).orElse(null);
       
        userRepository.deleteById(userId);
        return utl;
    }

 
    public User updateUserName(Long userId, User user){
        User u = getUserById(userId);
        u.setUserName(user.getUserName());
        return userRepository.save(u);
    }
  
	 
}

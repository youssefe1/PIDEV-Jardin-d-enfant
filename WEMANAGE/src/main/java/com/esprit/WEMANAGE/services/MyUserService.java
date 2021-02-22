package com.esprit.WEMANAGE.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.esprit.WEMANAGE.entities.*;
import com.esprit.WEMANAGE.repositories.UserRepository;
import com.esprit.WEMANAGE.security.SecurityConfig;


@Service
public class MyUserService implements UserDetailsService{

	
	 @Autowired
	    UserRepository userRepository;

	    @Autowired
	    SecurityConfig securityConfig;



	    @Override
	    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
	        Optional<User> user= userRepository.getUserByUserName(userName);
	        user.orElseThrow(()-> new UsernameNotFoundException("No user with the username "+userName));
	        // return user.map(MyUserDetails ::new).get();
	        return new MyUserDetails(user.get());
	    }

	    public User getUserById(Long id) {
	        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No " +
	                "user found with the ID "+ id));
	    }

	    public List<User> getAllUsers(){
	        return (List<User>) userRepository.findAll();
	    }

	    public User addUser(User user) throws Exception {
	        if (userRepository.getUserByUserName(user.getUserName()).isPresent()) throw new Exception("This " +
	                "username " +
	                "already exist");
	        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
	        user.setRoles("ROLE_USER");
	        user.setActive(true);
	        return userRepository.save(user);
	    }

	    public User addAdmin(User user) throws Exception {
	        if (userRepository.getUserByUserName(user.getUserName()).isPresent()) throw new Exception("This username " +
	                "already exist");
	        user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
	        user.setRoles("ROLE_ADMIN");
	        user.setActive(true);
	        return userRepository.save(user);
	    }


	    public User updateUserName(Long userId, User user){
	        User u = getUserById(userId);
	        u.setUserName(user.getUserName());
	        return userRepository.save(u);
	    }
}

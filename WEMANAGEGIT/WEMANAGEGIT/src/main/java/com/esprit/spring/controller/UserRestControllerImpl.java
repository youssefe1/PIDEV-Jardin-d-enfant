package com.esprit.spring.controller;


import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entities.User;
import com.esprit.spring.service.MyUserService;




@RestController
@RequestMapping("")
public class UserRestControllerImpl {

    @Autowired
    MyUserService userService;

    
   /* @GetMapping("/user/fb")
    public String welcome(Principal principal) {
        Map<String, Object> details = (Map<String, Object>)
                ((OAuth2Authentication) principal).getUserAuthentication().getDetails();
        String userName = (String) details.get("name");
        return "Hi " + userName + " Welcome to my application !!";
    }*/
    
    
    @GetMapping("/user/fb")
    public Principal getUser(Principal user){
    	return user;
    }
    
    


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user/add")
    public ResponseEntity<User> addUser(@RequestBody User user, BindingResult result) throws Exception {
        if (result.hasErrors())
            System.err.println(result.getAllErrors());
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
    
    @PostMapping("/admin/add")
    public ResponseEntity<User> addAdmin(@RequestBody User user, BindingResult result) throws Exception {
        if (result.hasErrors())
            System.err.println(result.getAllErrors());
        return new ResponseEntity<>(userService.addAdmin(user), HttpStatus.CREATED);
    }
    @DeleteMapping("/user/{id}/delete")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }
    @PutMapping("/user/{id}/edit")
    public ResponseEntity<User> UpdateUser(@RequestBody User user , @PathVariable Long id){
    
    	
    	 return new ResponseEntity<>(userService.updateUserName(id, user), HttpStatus.OK);
    }

    
  
}

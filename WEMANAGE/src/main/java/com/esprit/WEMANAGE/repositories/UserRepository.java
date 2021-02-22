package com.esprit.WEMANAGE.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.WEMANAGE.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	 public Optional<User> getUserByUserName(String userName);

	    public List<User> getUsersByRoles(String role);

}

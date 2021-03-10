package com.esprit.spring.repository;


import com.esprit.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
	
	Optional<User> findByUserName(String username);


    public List<User> getUsersByRoles(String role);

}

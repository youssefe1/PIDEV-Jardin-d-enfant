package com.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.User;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
	
	Optional<User> findByUserName(String username);
	 

    public List<User> getUsersByRoles(String role);
    
    @Query(value="select * from user n where n.user_id=0",nativeQuery=true)
	public List<User> getUserProfile();
    
   

}

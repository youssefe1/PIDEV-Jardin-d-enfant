package com.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.User;


@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
	
    //public Optional<User> getUserByUserName(String userName);
    //public List<User> findByRoles(String Roles);
	//public List<User> getUserByUserName(String userName);
	/*@Query("select * from User u where (u.userName like :userName)")
	public <List> User getUsersByUserName(@Param("userName")String userName);*/
}

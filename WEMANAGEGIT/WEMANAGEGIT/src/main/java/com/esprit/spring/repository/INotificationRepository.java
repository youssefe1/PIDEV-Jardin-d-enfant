package com.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Notification;

@Repository
public interface INotificationRepository extends JpaRepository<Notification,Long>{
	


	@Query("select n.Body from Notification n order by created_at desc ")
	public List<String> getAllNotifTrieJPQL();
	
	
	
	@Query("select count(n) from Notification n where Seen=1 and user_id=1")
	public long getnombreNotification();
}

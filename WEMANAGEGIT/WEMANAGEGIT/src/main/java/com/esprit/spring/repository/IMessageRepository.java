package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Message;
@Repository
public interface IMessageRepository  extends JpaRepository<Message,Long>{

	
	
	@Query("select m.body from Message m ORDER BY  date DESC ")
	public List<String> getAllMessageTrieJPQL();

	@Query(value="SELECT * FROM message m WHERE ROUND(TIME_TO_SEC(timediff(now(),m.date))/60) < 10",nativeQuery=true)
	public List<Message> findHistory();

}

package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Message;
@Repository
public interface IMessageRepository  extends JpaRepository<Message,Long>{

}

package com.esprit.spring.repository;

import com.esprit.spring.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findByPost_Id(Long aLong);
    List<Comment>findByUser_Id(Long userId);
}

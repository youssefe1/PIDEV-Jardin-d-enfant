package com.example.demo.repository;

import com.example.demo.model.LikeComment;
import com.example.demo.model.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePostRepository  extends JpaRepository<LikePost,Long> {
}

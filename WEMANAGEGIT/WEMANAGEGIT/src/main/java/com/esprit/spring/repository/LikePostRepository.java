package com.esprit.spring.repository;

import com.esprit.spring.entities.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikePostRepository  extends JpaRepository<LikePost,Long> {

    Optional<LikePost> findByUser_IdAndPost_Id(Long aLong,Long postid);
    List<LikePost> findByPost_Id(Long aLong);
    List<LikePost> findByUser_Id(Long aLong);


}

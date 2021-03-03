package com.esprit.spring.repository;

import com.esprit.spring.entities.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment,Long> {
    Optional<LikeComment> findByUser_IdAndComment_Id(Long aLong,Long postid);
    List<LikeComment> findByComment_Id(Long aLong);
    List<LikeComment> findByUser_Id(Long aLong);
}

package com.esprit.WEMANAGE.repositories;

import com.esprit.WEMANAGE.entities.LikeComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment,Long> {
}

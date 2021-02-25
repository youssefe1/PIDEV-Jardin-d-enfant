package com.esprit.WEMANAGE.repositories;

import com.esprit.WEMANAGE.entities.LikeComment;
import com.esprit.WEMANAGE.entities.LikePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikePostRepository  extends JpaRepository<LikePost,Long> {
}

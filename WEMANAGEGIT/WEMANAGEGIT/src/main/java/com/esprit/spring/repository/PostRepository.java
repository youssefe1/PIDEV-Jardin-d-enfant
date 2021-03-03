package com.esprit.spring.repository;

import com.esprit.spring.entities.Post;
import com.esprit.spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


    List<Post> findByUser(User user);
}

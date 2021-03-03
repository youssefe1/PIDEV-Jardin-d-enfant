package com.esprit.spring.service;

import com.esprit.spring.dto.PostDto;
import org.springframework.http.ResponseEntity;

public interface PostService {

    public ResponseEntity<?> createPost(PostDto postdto);

    public ResponseEntity<?> updatePost(PostDto postdto);

    public ResponseEntity<?> deletePost(PostDto postdto);

    public ResponseEntity<?> getAllPost();

    public ResponseEntity<?> getPostById(PostDto postdto);
    public ResponseEntity<?> getPostByUserId(long id) ;
    public ResponseEntity<?> likePost(PostDto postDto) ;
    public ResponseEntity<?> dislikePost(PostDto postDto) ;
    public ResponseEntity<?> removelikeDislikePost(PostDto postDto) ;
    public ResponseEntity<?> getLikeByPostId(long id) ;
    public ResponseEntity<?> getLikeByUserId(long id) ;


}

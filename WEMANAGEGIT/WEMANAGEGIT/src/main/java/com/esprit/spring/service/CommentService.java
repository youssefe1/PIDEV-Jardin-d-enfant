package com.esprit.spring.service;

import com.esprit.spring.dto.CommentDto;
import org.springframework.http.ResponseEntity;

public interface CommentService {
    public ResponseEntity<?> createComment(CommentDto commentDto);

    public ResponseEntity<?> getLikeByUserId(long id);
    public ResponseEntity<?> getLikeByCommentId(long id);
    public ResponseEntity<?> removelikeDislikeComment(CommentDto commentDto);
    public ResponseEntity<?> dislikeComment(CommentDto commentDto);
    public ResponseEntity<?> likeComment(CommentDto commentDto);
    public ResponseEntity<?> getCommentByUserId(long id);
    public ResponseEntity<?> getCommentById(CommentDto commentDto);
    public ResponseEntity<?> getCommentByPostId(long id);
    public ResponseEntity<?> deleteComment(CommentDto commentDto);
    public ResponseEntity<?> updateComment(CommentDto commentDto) ;
    }

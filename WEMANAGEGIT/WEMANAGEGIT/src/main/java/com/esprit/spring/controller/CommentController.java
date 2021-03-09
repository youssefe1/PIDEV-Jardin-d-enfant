package com.esprit.spring.controller;

import com.esprit.spring.dto.CommentDto;
import com.esprit.spring.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentServiceImpl commentService;

    @PostMapping("")
    public ResponseEntity<?> createcomment(@RequestBody CommentDto commentDto){


        return this.commentService.createComment(commentDto);

    }




    @GetMapping("/user/{id}")
    public ResponseEntity<?> getCommentsByUserId(@PathVariable("id") long id){
        return commentService.getCommentByUserId(id);

    }
    @GetMapping("/post/{id}")
    public ResponseEntity<?> getCommentsByPostId(@PathVariable("id") long id){
        return commentService.getCommentByPostId(id);

    }
    @PutMapping("")
    public ResponseEntity<?> updateComment(@RequestBody CommentDto commentDto){
        return this.commentService.updateComment(commentDto);
    }
    @DeleteMapping("")
    public ResponseEntity<?> deleteComment(@RequestBody CommentDto commentDto){

        return    this.commentService.deleteComment(commentDto);
    }
    @PostMapping("/like")
    public ResponseEntity<?> likePost(@RequestBody CommentDto commentDto){

        return    this.commentService.likeComment(commentDto);

    }
    @PostMapping("/dislike")
    public ResponseEntity<?> dislikePost(@RequestBody CommentDto commentDto){

        return    this.commentService.dislikeComment(commentDto);

    }
    @DeleteMapping("/removeLikeDislike")
    public ResponseEntity<?> removeLikeDislikeComment(@RequestBody CommentDto commentDto){

        return this.commentService.removelikeDislikeComment(commentDto);
    }

    @GetMapping("/likeByuserId/{id}")
    public ResponseEntity<?> getlikeByUserId(@PathVariable("id") long id){

        return commentService.getLikeByUserId(id);

    }
    @GetMapping("/likeByPostId/{id}")
    public ResponseEntity<?> getlikeByPostId(@PathVariable("id") long id){

        return commentService.getLikeByUserId(id);

    }













}

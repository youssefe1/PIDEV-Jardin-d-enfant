package com.esprit.spring.controller;

import com.esprit.spring.dto.PostDto;
import com.esprit.spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")

public class PostController {

    @Autowired
    PostService postService;



    @PostMapping("")
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){



        return this.postService.createPost(postDto);
    }
@GetMapping("")
public ResponseEntity<?> getAllPosts(){
   return      this.postService.getAllPost();

}

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getPostsUser(@PathVariable("id") long id){
return postService.getPostByUserId(id);

    }
@PutMapping("")
    public ResponseEntity<?> updatePost(@RequestBody PostDto postDto){
        return this.postService.updatePost(postDto);
}
@DeleteMapping("")
    public ResponseEntity<?> deletePost(@RequestBody PostDto postDto){

     return    this.postService.deletePost(postDto);
}
@PostMapping("/like")
    public ResponseEntity<?> likePost(@RequestBody PostDto postDto){

     return    this.postService.likePost(postDto);

}
    @PostMapping("/dislike")
    public ResponseEntity<?> dislikePost(@RequestBody PostDto postDto){

        return    this.postService.dislikePost(postDto);

    }
    @DeleteMapping("/removeLikeDislike")
        public ResponseEntity<?> removeLikeDislikePost(@RequestBody PostDto postDto){

        return this.postService.removelikeDislikePost(postDto);
        }

    @GetMapping("/likeByuser/{id}")
    public ResponseEntity<?> getlikeByUserId(@PathVariable("id") long id){

        return postService.getLikeByUserId(id);

    }
    @GetMapping("/likeByPost/{id}")
    public ResponseEntity<?> getlikeByPostId(@PathVariable("id") long id){

        return postService.getLikeByPostId(id);

    }
}

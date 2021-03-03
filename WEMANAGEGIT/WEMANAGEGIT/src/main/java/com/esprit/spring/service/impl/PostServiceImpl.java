package com.esprit.spring.service.impl;

import com.esprit.spring.dto.PostDto;
import com.esprit.spring.entities.LikePost;
import com.esprit.spring.entities.Post;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.LikePostRepository;
import com.esprit.spring.repository.PostRepository;
import com.esprit.spring.repository.UserRepository;
import com.esprit.spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LikePostRepository likePostRepository;


    @Override
    public ResponseEntity<?> createPost(PostDto postDto) {

        long userId = postDto.getUserId();
        Optional<User> user = userRepository.findById(userId);//object
        if (!user.isPresent()) {

            return ResponseEntity.status(404).body("user not found");
        } else {

            Post post = new Post();
            post.setUser(user.get());
            post.setTextContent(postDto.getPostContent());
            post.setUrlMedia(postDto.getUrlMedia());
            postRepository.save(post);
            return ResponseEntity.status(200).body("success");

        }
    }

    @Override
    public ResponseEntity<?> updatePost(PostDto postDto) {

        Optional<Post> post = postRepository.findById(postDto.getPostId());
        if (post.isPresent()) {
            Post postToUpdate = post.get();
            postToUpdate.setUrlMedia(postDto.getUrlMedia());
            postToUpdate.setTextContent(postDto.getPostContent());
            postRepository.save(postToUpdate);
            return ResponseEntity.status(200).body("success");

        }
        return ResponseEntity.status(404).body("Post not Found");
    }


    @Override
    public ResponseEntity<?> deletePost(PostDto postDto) {
        Optional<Post> post = postRepository.findById(postDto.getPostId());
        if (post.isPresent()) {
            postRepository.delete(post.get());
            return ResponseEntity.status(200).body("success");

        }

        return ResponseEntity.status(404).body("post not found");
    }

    @Override
    public ResponseEntity<?> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return ResponseEntity.status(200).body(posts);
    }

    @Override
    public ResponseEntity<?> getPostById(PostDto postDto) {
        Optional<Post> post = postRepository.findById(postDto.getPostId());
        if (post.isPresent()) {

            return ResponseEntity.status(200).body(post);

        }
        return ResponseEntity.status(404).body("post not found");

    }

    @Override
    public ResponseEntity<?> getPostByUserId(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            List<Post> posts = postRepository.findByUser(user.get());
            return ResponseEntity.status(200).body(posts);

        }
        return ResponseEntity.status(404).body("user not found");
    }

    @Override
    public ResponseEntity<?> likePost(PostDto postDto) {


        Optional<Post> post = postRepository.findById(postDto.getPostId());
        Optional<User> user = userRepository.findById(postDto.getUserId());
        Optional<LikePost> likePost = likePostRepository.findByUser_IdAndPost_Id(postDto.getUserId(), postDto.getPostId());
        if (!user.isPresent() || !post.isPresent()) {
            return ResponseEntity.status(404).body("user/post not found");
        } else if (likePost.isPresent() && likePost.get().isLike()) {
            return ResponseEntity.status(400).body("user already like this post");
        }
        if(likePost.isPresent() && likePost.get().isDisLike())
        {
            LikePost likeUserPost=  likePost.get();
            likeUserPost.setDisLike(false);
            likeUserPost.setLike(!likePost.get().isLike());
            likePostRepository.save(likeUserPost);
            return ResponseEntity.status(200).body("success");
        }

            LikePost likeUserPost = new LikePost();
            likeUserPost.setUser(user.get());
            likeUserPost.setPost(post.get());
            likeUserPost.setDisLike(false);
            likeUserPost.setLike(true);
            likePostRepository.save(likeUserPost);

            return ResponseEntity.status(200).body("success");

    }

    @Override
    public ResponseEntity<?> dislikePost(PostDto postDto) {


        Optional<Post> post = postRepository.findById(postDto.getPostId());
        Optional<User> user = userRepository.findById(postDto.getUserId());
        Optional<LikePost> likePost = likePostRepository.findByUser_IdAndPost_Id(postDto.getUserId(), postDto.getPostId());
        if (!user.isPresent() || !post.isPresent()) {
            return ResponseEntity.status(404).body("user/post not found");
        } else if (likePost.isPresent() && likePost.get().isDisLike()) {
            return ResponseEntity.status(400).body("user already dislike this post");
        }
        if(likePost.isPresent() && likePost.get().isLike())
        {
            LikePost likeUserPost=  likePost.get();
            likeUserPost.setLike(false);
            likeUserPost.setDisLike(!likePost.get().isDisLike());
            likePostRepository.save(likeUserPost);
            return ResponseEntity.status(200).body("success");
        }

        LikePost likeUserPost = new LikePost();
        likeUserPost.setUser(user.get());
        likeUserPost.setPost(post.get());
        likeUserPost.setDisLike(true);
        likeUserPost.setLike(false);
        likePostRepository.save(likeUserPost);

        return ResponseEntity.status(200).body("success");

    }

    @Override
    public ResponseEntity<?> removelikeDislikePost(PostDto postDto) {
        Optional<LikePost> postLike = likePostRepository.findByUser_IdAndPost_Id(postDto.getUserId(), postDto.getUserId());
    if(postLike.isPresent()){
        likePostRepository.delete(postLike.get());
        return ResponseEntity.status(200).body("success");

    }
        return ResponseEntity.status(404).body("Not found");

    }

    @Override
    public ResponseEntity<?> getLikeByPostId(long id) {
        List<LikePost> likePost = likePostRepository.findByPost_Id(id);
    return ResponseEntity.status(200).body(likePost);

    }

    @Override
    public ResponseEntity<?> getLikeByUserId(long id) {
        List<LikePost> likePost = likePostRepository.findByUser_Id(id);
        return ResponseEntity.status(200).body(likePost);
    }


}

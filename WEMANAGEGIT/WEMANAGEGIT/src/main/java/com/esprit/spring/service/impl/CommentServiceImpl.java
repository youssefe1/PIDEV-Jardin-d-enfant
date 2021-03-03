package com.esprit.spring.service.impl;

import com.esprit.spring.dto.CommentDto;
import com.esprit.spring.entities.Comment;
import com.esprit.spring.entities.LikeComment;
import com.esprit.spring.entities.Post;
import com.esprit.spring.entities.User;
import com.esprit.spring.repository.CommentRepository;
import com.esprit.spring.repository.LikeCommentRepository;
import com.esprit.spring.repository.PostRepository;
import com.esprit.spring.repository.UserRepository;
import com.esprit.spring.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentServiceImpl  implements CommentService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PostRepository postRepository;

    @Autowired
    LikeCommentRepository likeCommentRepository;
    @Override
    public ResponseEntity<?> createComment(CommentDto commentDto) {
        Optional<User> user = userRepository.findById(commentDto.getUserId());
        Optional<Post> post = postRepository.findById(commentDto.getPostId());
        if(!user.isPresent() || !post.isPresent()){
            return ResponseEntity.status(404).body("user/post not found ");
        }
        else {
            Comment comment=new Comment();
            comment.setUser(user.get());
            comment.setPost(post.get());
            comment.setContent(commentDto.getContent());
            commentRepository.save(comment);
            return ResponseEntity.status(200).body("success ");

        }

    }

    @Override
    public ResponseEntity<?> updateComment(CommentDto commentDto) {

        Optional<Comment> comment = commentRepository.findById(commentDto.getCommentId());
        if (comment.isPresent()) {
            Comment commentToUpdate = comment.get();
            commentToUpdate.setContent(commentDto.getContent());
            commentRepository.save(commentToUpdate);
            return ResponseEntity.status(200).body("success");

        }
        return ResponseEntity.status(404).body("Comment not Found");
    }


    @Override
    public ResponseEntity<?> deleteComment(CommentDto commentDto) {
        Optional<Comment> comment = commentRepository.findById(commentDto.getCommentId());
        if (comment.isPresent()) {
            commentRepository.delete(comment.get());
            return ResponseEntity.status(200).body("success");

        }

        return ResponseEntity.status(404).body("post not found");
    }

    @Override
    public ResponseEntity<?> getCommentByPostId(long id) {
        List<Comment> comments = commentRepository.findByPost_Id(id);
        return ResponseEntity.status(200).body(comments);
    }

    @Override
    public ResponseEntity<?> getCommentById(CommentDto commentDto) {
        Optional<Post> post = postRepository.findById(commentDto.getCommentId());
        if (post.isPresent()) {

            return ResponseEntity.status(200).body(post);

        }
        return ResponseEntity.status(404).body("comment not found");

    }


    public ResponseEntity<?> getCommentByUserId(long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            List<Comment> comments = commentRepository.findByUser_Id(id);
            return ResponseEntity.status(200).body(comments);

        }
        return ResponseEntity.status(404).body("user not found");
    }

        public ResponseEntity<?> likeComment(CommentDto commentDto) {


        Optional<Comment> comment = commentRepository.findById(commentDto.getCommentId());
        Optional<User> user = userRepository.findById(commentDto.getUserId());
        Optional<LikeComment> likeComment = likeCommentRepository.findByUser_IdAndComment_Id(commentDto.getUserId(), commentDto.getCommentId());
        if (!user.isPresent() || !comment.isPresent()) {
            return ResponseEntity.status(404).body("user/comment not found");
        } else if (likeComment.isPresent() && likeComment.get().isLike()) {
            return ResponseEntity.status(400).body("user already like this comment");
        }
        if(likeComment.isPresent() && likeComment.get().isDisLike())
        {
            LikeComment likeUserComment=  likeComment.get();
            likeUserComment.setDisLike(false);
            likeUserComment.setLike(!likeComment.get().isLike());
            likeCommentRepository.save(likeUserComment);
            return ResponseEntity.status(200).body("success");
        }

            LikeComment likeUserComment = new LikeComment();
            likeUserComment.setUser(user.get());
            likeUserComment.setComment(comment.get());
            likeUserComment.setDisLike(false);
            likeUserComment.setLike(true);
            likeCommentRepository.save(likeUserComment);

        return ResponseEntity.status(200).body("success");

    }

    @Override
    public ResponseEntity<?> dislikeComment(CommentDto commentDto) {


        Optional<Comment> comment = commentRepository.findById(commentDto.getCommentId());
        Optional<User> user = userRepository.findById(commentDto.getUserId());
        Optional<LikeComment> likeComment = likeCommentRepository.findByUser_IdAndComment_Id(commentDto.getUserId(), commentDto.getCommentId());
        if (!user.isPresent() || !comment.isPresent()) {
            return ResponseEntity.status(404).body("user/post not found");
        } else if (likeComment.isPresent() && likeComment.get().isDisLike()) {
            return ResponseEntity.status(400).body("user already dislike this post");
        }
        if(likeComment.isPresent() && likeComment.get().isLike())
        {
            LikeComment likeUserComment=  likeComment.get();
            likeUserComment.setLike(false);
            likeUserComment.setDisLike(!likeComment.get().isDisLike());
            likeCommentRepository.save(likeUserComment);
            return ResponseEntity.status(200).body("success");
        }

        LikeComment likeUserComment = new LikeComment();
        likeUserComment.setUser(user.get());
        likeUserComment.setComment(comment.get());
        likeUserComment.setDisLike(true);
        likeUserComment.setLike(false);
        likeCommentRepository.save(likeUserComment);

        return ResponseEntity.status(200).body("success");

    }

    @Override
    public ResponseEntity<?> removelikeDislikeComment(CommentDto commentDto) {
        Optional<LikeComment> likeComment = likeCommentRepository.findByUser_IdAndComment_Id(commentDto.getUserId(), commentDto.getUserId());
        if(likeComment.isPresent()){
            likeCommentRepository.delete(likeComment.get());
            return ResponseEntity.status(200).body("success");

        }
        return ResponseEntity.status(404).body("Not found");

    }

    @Override
    public ResponseEntity<?> getLikeByCommentId(long id) {
        List<LikeComment> likeComments = likeCommentRepository.findByComment_Id(id);
        return ResponseEntity.status(200).body(likeComments);

    }

    @Override
    public ResponseEntity<?> getLikeByUserId(long id) {
        List<LikeComment> likeComments = likeCommentRepository.findByUser_Id(id);
        return ResponseEntity.status(200).body(likeComments);
    }
}

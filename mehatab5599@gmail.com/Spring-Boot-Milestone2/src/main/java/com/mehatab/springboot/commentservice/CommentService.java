package com.mehatab.springboot.commentservice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mehatab.springboot.Entity.Comment;
import com.mehatab.springboot.Entity.Post;
import com.mehatab.springboot.Exception.ResourceNotFoundException;
import com.mehatab.springboot.Repository.CommentRepository;
import com.mehatab.springboot.Repository.PostRepository;

@Service
public class CommentService 
{
	@Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public Comment createComment(Long postId, String content) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (!postOptional.isPresent()) {
            throw new ResourceNotFoundException("Post not found with id " + postId);
        }

        Comment comment = new Comment();
        comment.setPost(postOptional.get());
        comment.setContent(content);
        comment.setCreatedDate(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (!postOptional.isPresent()) {
            throw new ResourceNotFoundException("Post not found with id " + postId);
        }

        return commentRepository.findByPostIdOrderByCreatedDateDesc(postId);
    }
    
    
}


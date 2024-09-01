package com.mehatab.springboot.PostController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehatab.springboot.Entity.Comment;
import com.mehatab.springboot.Exception.ResourceNotFoundException;
import com.mehatab.springboot.commentservice.CommentService;

@RestController
@RequestMapping("/posts")
public class PostController 
{
	 @Autowired
	    private CommentService commentService;

	    @PostMapping("/{id}/comments")
	    public ResponseEntity<Comment> addComment(@PathVariable Long id, @RequestBody String content) 
	    {
	        try {
	            Comment comment = commentService.createComment(id, content);
	            return new ResponseEntity<>(comment, HttpStatus.CREATED);
	        } catch (ResourceNotFoundException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/{id}/comments")
	    public ResponseEntity<List<Comment>> getComments(@PathVariable Long id) {
	        try {
	            List<Comment> comments = commentService.getCommentsByPostId(id);
	            return new ResponseEntity<>(comments, HttpStatus.OK);
	        } catch (ResourceNotFoundException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
}

package com.mehatab.springboot.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "post_id", nullable = false)
	    private Post post;

	    @Column(nullable = false)
	    private String content;

	    @Column(nullable = false)
	    private LocalDateTime createdDate;

	    // Getters and Setters
	    public Long getId() 
	    { 
	    	return id; 
	    }
	    public void setId(Long id) 
	    { 
	    	this.id = id; 
	    }

	    public Post getPost() 
	    { 
	    	return post; 
	    }
	    public void setPost(Post post) 
	    { 
	    	this.post = post; 
	    }

	    public String getContent() 
	    { 
	    	return content; 
	    }
	    public void setContent(String content) 
	    { 
	    	this.content = content; 
	    }

	    public LocalDateTime getCreatedDate() 
	    {
	    	return createdDate; 
	    }
	    public void setCreatedDate(LocalDateTime createdDate) 
	    { 
	    	this.createdDate = createdDate; 
	    }
	
	
	
	

}

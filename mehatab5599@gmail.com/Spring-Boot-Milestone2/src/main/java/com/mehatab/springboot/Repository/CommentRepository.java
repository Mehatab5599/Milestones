package com.mehatab.springboot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehatab.springboot.Entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> 
{
		List<Comment> findByPostIdOrderByCreatedDateDesc(Long postId);
		
}

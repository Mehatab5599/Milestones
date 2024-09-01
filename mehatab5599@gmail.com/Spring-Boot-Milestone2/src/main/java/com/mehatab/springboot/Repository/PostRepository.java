package com.mehatab.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mehatab.springboot.Entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> 
{
	//Additional query method (if needed)
}

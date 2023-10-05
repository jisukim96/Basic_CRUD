package com.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.post.Domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

//	Optional<Post> findById(Integer Id);
	
}

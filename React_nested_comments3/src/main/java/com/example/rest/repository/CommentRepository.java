package com.example.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	
	List<Comment> findByPostIdAndParentIsNull(Long postId);
}

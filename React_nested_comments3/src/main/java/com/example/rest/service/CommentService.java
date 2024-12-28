package com.example.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.Comment;
import com.example.rest.repository.CommentRepository;


@Service
public class CommentService {

	
	
	@Autowired private CommentRepository commentRepository;
	
	public List<Comment> getCommentsByPost(Long postId) 
	{
		
		return commentRepository.findByPostIdAndParentIsNull(postId); 
		
	}
	
	public Comment saveComment(Comment comment)
	{ 
		
		return commentRepository.save(comment); 
		
	}
	
	public Comment findCommentById(Long id) {
	    return commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Comment not found"));
	}

	
	
}

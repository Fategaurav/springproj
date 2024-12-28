package com.example.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rest.entity.Post;
import com.example.rest.repository.PostRepository;


@Service
public class PostService {

	
	@Autowired
	private PostRepository postRepository;
	public List<Post> getAllPosts()
	{ 
		return postRepository.findAll();
		
	}
	
	public Optional<Post> getPostById(Long id) 
	
	{
		return postRepository.findById(id);
		
	}
	
	public Post savePost(Post post)
	{
		return postRepository.save(post);
		
	}
}

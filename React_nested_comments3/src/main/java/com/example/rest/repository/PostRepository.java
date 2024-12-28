package com.example.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}

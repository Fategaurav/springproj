package com.example.rest.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String body;
    private String author;
    private String timestamp; // Use LocalDateTime for timestamp

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference(value = "post-comments") // Unique value for @JsonBackReference
    private Post post;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference(value = "parent-replies") // Unique value for @JsonBackReference
    private Comment parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "parent-replies") // Unique value for @JsonManagedReference
    private List<Comment> comments;
}

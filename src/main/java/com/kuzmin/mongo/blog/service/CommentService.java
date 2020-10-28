package com.kuzmin.mongo.blog.service;

import com.kuzmin.mongo.blog.model.Comment;
import com.kuzmin.mongo.blog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}

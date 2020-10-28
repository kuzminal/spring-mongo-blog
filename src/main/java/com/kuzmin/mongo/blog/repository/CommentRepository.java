package com.kuzmin.mongo.blog.repository;

import com.kuzmin.mongo.blog.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment, String> {
}

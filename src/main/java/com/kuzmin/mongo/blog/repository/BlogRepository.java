package com.kuzmin.mongo.blog.repository;

import com.kuzmin.mongo.blog.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, String> {
}

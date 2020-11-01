package com.kuzmin.mongo.blog.repository;

import com.kuzmin.mongo.blog.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {
}

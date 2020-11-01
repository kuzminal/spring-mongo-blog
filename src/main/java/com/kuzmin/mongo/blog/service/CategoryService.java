package com.kuzmin.mongo.blog.service;

import com.kuzmin.mongo.blog.dto.CategoryDTO;
import com.kuzmin.mongo.blog.model.Category;
import com.kuzmin.mongo.blog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addUpdateCategory(Category category) {
        categoryRepository.save(category);
        return categoryRepository.findById(category.get_id()).orElse(null);
    }

    public CategoryDTO getCategoryById(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            return new CategoryDTO(category.get_id(), category.getName());
        } else {
            return null;
        }
    }
}

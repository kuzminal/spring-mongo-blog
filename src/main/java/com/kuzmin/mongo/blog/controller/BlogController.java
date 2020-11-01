package com.kuzmin.mongo.blog.controller;

import com.kuzmin.mongo.blog.dto.BlogDTO;
import com.kuzmin.mongo.blog.model.Blog;
import com.kuzmin.mongo.blog.model.Category;
import com.kuzmin.mongo.blog.model.Comment;
import com.kuzmin.mongo.blog.service.BlogService;
import com.kuzmin.mongo.blog.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ui")
public class BlogController {
    BlogService blogService;
    CategoryService categoryService;

    public BlogController(BlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("/blogs")
    public List<BlogDTO> getAllBlogs(@RequestParam(required = false) Optional<String> categoryId) {
        return blogService.getAllBlogs(categoryId);
    }

    @PostMapping("/blogs")
    public Blog addBlog(@RequestBody Blog blog) {
        return blogService.addUpdateBlog(blog);
    }

    @GetMapping("/blogs/{blogId}")
    public Blog getBlog(@PathVariable("blogId") String blogId) {
        return blogService.getBlog(blogId);
    }

    @DeleteMapping("/blogs/{blogId}")
    public void deleteBlog(@PathVariable("blogId") String blogId) {
        blogService.deleteBlog(blogId);
    }

    @GetMapping("/blogs/{blogId}/comments")
    public List<Comment> getAllComments(@PathVariable("blogId") String blogId) {
        return blogService.getAllComments(blogId);
    }

    @PostMapping("/blogs/{blogId}/comments")
    public Comment addComment(@RequestBody Comment comment, @PathVariable("blogId") String blogId) {
        return blogService.addComment(comment, blogId);
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addUpdateCategory(category);
    }
}

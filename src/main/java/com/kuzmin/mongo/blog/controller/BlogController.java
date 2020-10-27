package com.kuzmin.mongo.blog.controller;

import com.kuzmin.mongo.blog.model.Blog;
import com.kuzmin.mongo.blog.model.Comment;
import com.kuzmin.mongo.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
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
}

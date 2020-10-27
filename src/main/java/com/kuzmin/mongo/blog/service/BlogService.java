package com.kuzmin.mongo.blog.service;

import com.kuzmin.mongo.blog.model.Blog;
import com.kuzmin.mongo.blog.model.Comment;
import com.kuzmin.mongo.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public Blog addUpdateBlog(Blog blog) {
        blogRepository.save(blog);
        return blogRepository.findById(blog.getId()).orElse(null);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlog(String blogId) {
        Optional<Blog> blogObj = blogRepository.findById(blogId);
        return blogObj.orElse(null);
    }

    public List<Comment> getAllComments(String blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        if (blog.isPresent()) {
            return blog.get().getComments();
        } else return Collections.emptyList();
    }

    public Comment addComment(Comment comment, String blogId) {
        Blog blog = blogRepository.findById(blogId).orElse(null);
        if (blog != null) {
            blog.addComment(comment);
            blog.incrementCommnetsCount();
            blogRepository.save(blog);
        }
        return comment;
    }

    /*public List<Blog> search(String searchTxt) {
        return this.blogRepository.search(searchTxt);
    }*/

    public void deleteBlog(String blogId) {
        Optional<Blog> blogObj = this.blogRepository.findById(blogId);
        blogObj.ifPresent(blog -> this.blogRepository.delete(blog));
    }
}

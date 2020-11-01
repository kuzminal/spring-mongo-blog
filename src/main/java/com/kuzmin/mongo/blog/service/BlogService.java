package com.kuzmin.mongo.blog.service;

import com.kuzmin.mongo.blog.dto.BlogDTO;
import com.kuzmin.mongo.blog.model.Blog;
import com.kuzmin.mongo.blog.model.Comment;
import com.kuzmin.mongo.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BlogService {
    BlogRepository blogRepository;
    CategoryService categoryService;

    public BlogService(BlogRepository blogRepository, CategoryService categoryService) {
        this.blogRepository = blogRepository;
        this.categoryService = categoryService;
    }

    public Blog addUpdateBlog(Blog blog) {
        blogRepository.save(blog);
        return blogRepository.findById(blog.getId()).orElse(null);
    }

    public List<BlogDTO> getAllBlogs(Optional<String> categoryId) {
        List<Blog> blog;
        if (categoryId.isEmpty() || categoryId.get().equals("all")) {
            return convertToDTO(blogRepository.findAll());
        } else {
            return convertToDTO(blogRepository.findBlogByCategoryId(categoryId.get()));
        }
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

    public List<Blog> getAllBlogsByCategory(String categoryId) {
        return blogRepository.findBlogByCategoryId(categoryId);
    }

    /*public List<Blog> search(String searchTxt) {
        return this.blogRepository.search(searchTxt);
    }*/

    public void deleteBlog(String blogId) {
        Optional<Blog> blogObj = this.blogRepository.findById(blogId);
        blogObj.ifPresent(blog -> this.blogRepository.delete(blog));
    }

    private List<BlogDTO> convertToDTO(List<Blog> blogs) {
        if (blogs != null) {
            return blogs.stream()
                    .map(blog -> new BlogDTO(
                            blog.getId(),
                            blog.getTitle(),
                            blog.getBody(),
                            blog.getCreatedBy(),
                            blog.getPublishDate(),
                            blog.getCategoryId() != null ? categoryService.getCategoryById(blog.getCategoryId()).getName() : "",
                            blog.getCommentsCount()
                    ))
                    .collect(Collectors.toList());
        } else return null;
    }
}

package com.kuzmin.mongo.blog.controller;

import com.kuzmin.mongo.blog.service.BlogService;
import com.kuzmin.mongo.blog.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogUIController {
    BlogService blogService;
    CategoryService categoryService;

    public BlogUIController(BlogService blogService, CategoryService categoryService) {
        this.blogService = blogService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String welcome(Model model) {
        //model.addAttribute("blogs", blogService.getAllBlogs());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "/error/access-denied";
    }
}

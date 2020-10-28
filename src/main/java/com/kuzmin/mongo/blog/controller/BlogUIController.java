package com.kuzmin.mongo.blog.controller;

import com.kuzmin.mongo.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class BlogUIController {
    @Autowired
    BlogService blogService;

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "home";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
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

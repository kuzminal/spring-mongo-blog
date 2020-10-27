package com.kuzmin.mongo.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class BlogUIController {
    @GetMapping("/")
    public String welcome(Model model) {
        return "index";
    }
}

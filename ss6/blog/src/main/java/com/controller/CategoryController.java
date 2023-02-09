package com.controller;

import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
@GetMapping("/category")
    public String showList(Model model) {
        model.addAttribute("category", categoryService.findAll());
        return "/category";
    }
}

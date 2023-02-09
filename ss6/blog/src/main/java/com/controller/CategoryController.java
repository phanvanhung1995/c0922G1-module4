package com.controller;

import com.model.Category;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.SAAJResult;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public String showList(Model model) {
        model.addAttribute("category", categoryService.findAll());
        return "/category";
    }

    @GetMapping("/category/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "/create_category";
    }

    @PostMapping("/category/save")
    public String save(Category category) {
        categoryService.create(category);
        return "redirect:/category";
    }
    @GetMapping("/category/edit/{id}")
    public String edit(Model model, @PathVariable int id) {
        Category category = categoryService.findById(id);
        model.addAttribute("category",category);
        return "/edit_category";
    }

    @PostMapping("/category/update")
    public String update(@ModelAttribute Category category) {
        categoryService.update(category);
        return "/category";
    }
}

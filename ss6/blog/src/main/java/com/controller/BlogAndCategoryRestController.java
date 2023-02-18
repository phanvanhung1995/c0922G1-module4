package com.controller;

import com.model.Blog;
import com.model.Category;
import com.service.BlogService;
import com.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/list")
public class BlogAndCategoryRestController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BlogService blogService;

    @GetMapping("/category")
    public ResponseEntity<List<Category>> getAllCategory() {
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }


    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getAllBlog() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> viewBlog(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Category> viewCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getAll(@RequestParam(required = false,defaultValue = "") String name,
                                             @RequestParam(required = false,defaultValue = "0") int page,
                                             @RequestParam(required = false,defaultValue = "2") int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Blog> blogPage = blogService.search(name, pageable);
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }
}

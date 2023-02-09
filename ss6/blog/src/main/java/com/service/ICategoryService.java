package com.service;

import com.model.Blog;
import com.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void create(Category category);

    void update(Category category);

    void delete(int id);
}

package com.service;

import com.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    List<Blog> findAll();

    Blog findById(int id);

    void create(Blog blog);

    void update(Blog blog);

    void delete(int id);

    public Page<Blog> findByNameContaining(String name, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

}

package com.repository;

import com.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByNameContaining(String nameSearch, Pageable pageable);


}

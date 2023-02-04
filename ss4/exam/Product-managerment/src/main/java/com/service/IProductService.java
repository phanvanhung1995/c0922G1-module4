package com.service;

import com.model.Product;
import com.service.impl.ProductService;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(int id);

    void create(Product product);

    void edit(int id, Product product);

    void delete(int id);

    void search(String name);
}

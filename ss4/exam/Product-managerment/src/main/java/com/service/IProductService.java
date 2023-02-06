package com.service;

import com.model.Product;
import com.service.impl.ProductService;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(int id);

    void create(Product product);

    void edit( Product product);

    void delete(int id);

    List<Product> search(String name);
}

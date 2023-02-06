package com.repo;


import com.model.Product;

import java.util.List;

public interface IProductRepository {
    void update(Product product);

    List<Product> getProducts();

    Product findById(int id);

    public void delete(int id) ;

    public List<Product> search(String name);
}

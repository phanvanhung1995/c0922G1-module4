package com.service.impl;

import com.model.Product;
import com.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone 11", 11, "gold", "apple"));
        productList.add(new Product(2, "iphone 12", 15, "red", "apple"));
        productList.add(new Product(3, "sam sung note 10", 10, "gold", "samsung"));
        productList.add(new Product(4, "vivo t 10", 11, "gold", "vivo"));

    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void edit(int id, Product product) {
        productList.set(id, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(productList.get(id));
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productSearch = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                productSearch.add(product);
            }
        }
        return productSearch;
    }
}

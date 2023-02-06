package com.service.impl;

import com.model.Product;
import com.repo.IProductRepository;
import com.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {

//    @PersistenceContext
//    EntityManager entityManager;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.getProducts();
    }


    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override

    public void create(Product product) {

    }


    @Override
    public void edit(Product product) {
        productRepository.update(product);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public List<Product> search(String name) {

        return productRepository.search(name);
    }
}

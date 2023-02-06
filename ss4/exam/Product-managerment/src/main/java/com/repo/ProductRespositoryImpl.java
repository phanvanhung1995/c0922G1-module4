package com.repo;

import com.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRespositoryImpl implements IProductRepository{

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public List<Product> getProducts() {
        return entityManager.createQuery("FROM Product").getResultList();
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Product product1 = findById(id);
        entityManager.remove(product1);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productSearch = new ArrayList<>();
        for (Product product : getProducts()) {
            if (product.getName().contains(name)) {
                productSearch.add(product);
            }
        }
        return productSearch;
    }
}

package com.service;

import com.model.Customer;

import java.util.List;

public interface IcustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void update(int id, Customer customer);

    void remove(int id);
}

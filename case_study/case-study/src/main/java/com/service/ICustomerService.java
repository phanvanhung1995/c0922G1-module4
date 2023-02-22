package com.service;

import com.model.customer.Customer;
import com.model.customer.CustomerType;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface ICustomerService {


    Customer findById(Long id);

    boolean save(Customer customer);

    void delete(Long id);

    Page<Customer> findAll(String name,String email,String customerTypeId,Pageable pageable);

}

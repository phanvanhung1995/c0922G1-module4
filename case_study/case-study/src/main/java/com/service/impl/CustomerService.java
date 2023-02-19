package com.service.impl;

import com.model.customer.Customer;
import com.repository.ICustomerRepository;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(org.springframework.data.domain.Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}

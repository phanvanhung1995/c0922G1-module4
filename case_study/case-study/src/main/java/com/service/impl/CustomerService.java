package com.service.impl;

import com.model.customer.Customer;
import com.model.customer.CustomerType;
import com.repository.ICustomerRepository;
import com.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService {
    @Autowired
   private ICustomerRepository customerRepository;



    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean save(Customer customer) {
        for(Customer customer1:customerRepository.findAll()) {
           if (customer1.getId()==customer.getId()) {
               return false;
           }
        }
        customerRepository.save(customer);
        return true;
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAll(String name, String email, String customerTypeId, Pageable pageable) {
        return customerRepository.findAll(name,email,customerTypeId,pageable);
    }


}

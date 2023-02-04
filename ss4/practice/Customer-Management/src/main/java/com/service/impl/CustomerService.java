package com.service.impl;

import com.model.Customer;
import com.service.IcustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CustomerService implements IcustomerService {

    private static final List<Customer> listcustomer = new ArrayList<>();

    static {
        listcustomer.add(new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        listcustomer.add(new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        listcustomer.add(new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        listcustomer.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        listcustomer.add( new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        listcustomer.add(new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }


    @Override
    public List<Customer> findAll() {
        return listcustomer;
    }

    @Override
    public Customer findById(int id) {
        return listcustomer.get(id);
    }

    @Override
    public void save(Customer customer) {
        listcustomer.add(customer);
    }

    @Override
    public void update( int id,Customer customer) {
        listcustomer.set(id,customer);
    }

    @Override
    public void remove(int id) {
        listcustomer.remove(id);
    }
}

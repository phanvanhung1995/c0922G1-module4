package com.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @OneToMany(mappedBy = "customerTypeId")
    Set<Customer> customerSet;

    public CustomerType() {
    }

    public CustomerType(long id, String name, Set<Customer> customerSet) {
        this.id = id;
        this.name = name;
        this.customerSet = customerSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }
}

package com.repository;

import com.model.customer.Customer;
import com.model.customer.CustomerType;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from Customer where name like concat('%',:name,'%') and email like concat('%',:searchEmail,'%')" +
            " and customer_type like concat('%',:customerType,'%')", nativeQuery = true)
    Page<Customer> findAll(@Param("name") String name, @Param("searchEmail") String email,
                           @Param("customerType") String customerType, Pageable pageable);
}

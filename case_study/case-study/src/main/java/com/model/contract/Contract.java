package com.model.contract;

import com.model.customer.Customer;
import com.model.employee.Employee;
import com.model.faccility.Facility;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "date")
    private String starDate;
    @Column(columnDefinition = "date")
    private String endDate;
    private double deposit;
    @ManyToOne
    @JoinColumn(name ="employee_id",nullable = false,referencedColumnName = "id")
    private Employee employeeID;
    @ManyToOne
    @JoinColumn(name ="customer_id",nullable = false,referencedColumnName = "id")
    private Customer customerID;
    @ManyToOne
    @JoinColumn(name ="facility_id",nullable = false,referencedColumnName = "id")
    private Facility facilityID;
}

package com.model.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String dateOfBirt;
    private String idCard;
    private double salary;
    private String phoneNumber;
    private String email;
    private String address;

}

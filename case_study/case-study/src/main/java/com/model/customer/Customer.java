package com.model.customer;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int")
    private long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @Column(columnDefinition = "date")
    private String dateOfBirt;
    @Column(columnDefinition = "bit(1)")
    private String gender;
    @Column(columnDefinition = "varchar(45)")
    private String idCard;
    @Column(columnDefinition = "varchar(45)")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(45)")

    private String email;
    @Column(columnDefinition = "varchar(45)")
    private String address;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false,referencedColumnName = "id")
    private CustomerType customerTypeId;

    public Customer() {
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

    public String getDateOfBirt() {
        return dateOfBirt;
    }

    public void setDateOfBirt(String dateOfBirt) {
        this.dateOfBirt = dateOfBirt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

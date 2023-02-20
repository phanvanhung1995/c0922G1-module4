package com.model.employee;

import com.model.contract.Contract;
import com.model.login.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @Column(columnDefinition = "date")
    private String dateOfBirt;
    @Column(columnDefinition = "varchar(45) unique")
    private String idCard;
    private double salary;
    @Column(columnDefinition = "varchar(45) unique")
    private String phoneNumber;
    @Column(columnDefinition = "varchar(45) unique")
    private String email;
    @Column(columnDefinition = "varchar(45)")
    private String address;
    @ManyToOne
    @JoinColumn(name = "position", nullable = false, referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "education_degree", nullable = false, referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "division", nullable = false, referencedColumnName = "id")
    private Division division;
    @OneToMany(mappedBy = "employeeID")
   private Set<Contract> contractSet;

    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "userName")
    private User user;

    public Employee() {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

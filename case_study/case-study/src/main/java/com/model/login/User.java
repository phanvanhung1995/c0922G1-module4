package com.model.login;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.employee.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @Column(columnDefinition = "varchar(225)")
    private String username;
    @Column(columnDefinition = "varchar(225)")
    @JsonIgnore
    private String password;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "username"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet;

    public User() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }
}

package com.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(45)")
    private String name;
    @OneToMany(mappedBy = "educationDegreeId")
    Set<Employee> employeeSet;

    public EducationDegree() {
    }

    public EducationDegree(long id, String name, Set<Employee> employeeSet) {
        this.id = id;
        this.name = name;
        this.employeeSet = employeeSet;
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

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}

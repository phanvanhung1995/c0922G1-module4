package com.model.faccility;

import com.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "varchar(45) unique")
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    @Column(columnDefinition = "varchar(45)")
    private String standardRoom;
    @Column(columnDefinition = "varchar(45)")
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;
    @ManyToOne
    @JoinColumn(name = "rent_type_id",nullable = false,referencedColumnName = "id")
    private RentType rentTypeId;
    @ManyToOne
    @JoinColumn(name = "facility_type_id",nullable = false,referencedColumnName = "id")
    private FacilityType facilityTypeID;

    @OneToMany(mappedBy = "facilityID")
    private Set<Contract> contractSet;
    public Facility() {
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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public FacilityType getFacilityTypeID() {
        return facilityTypeID;
    }

    public void setFacilityTypeID(FacilityType facilityTypeID) {
        this.facilityTypeID = facilityTypeID;
    }
}

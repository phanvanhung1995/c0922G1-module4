package com.model.dto;

import com.model.contract.Contract;
import com.model.faccility.FacilityType;
import com.model.faccility.RentType;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;


public class FacilityDto {

    private long id;
    @Pattern(regexp = "^([A-Z][a-z]*\\\\s)+[A-Z][a-z]*$", message = "Tên dịch vụ không chứa ký tự đặc bệt Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String name;
    @Pattern(regexp = "^[0-9]+", message = "diện tích phải lớn hơn không")
    private int area;
    @Pattern(regexp = "^[0-9]+", message = "số lượng phải lớn hơn không")
    private double cost;
    @Pattern(regexp = "^[0-9]+", message = "số lượng người phải lớn hơn không")
    private int maxPeople;

    private String standardRoom;

    private String descriptionOtherConvenience;
    @Pattern(regexp = "^[0-9]+", message = "diện tích  phải lớn hơn không")

    private double poolArea;

    private int numberOfFloors;
    private String facilityFree;

    private RentType rentTypeId;

    private FacilityType facilityTypeID;
    private Set<Contract> contractSet;

    public FacilityDto() {
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

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}

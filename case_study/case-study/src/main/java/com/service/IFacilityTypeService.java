package com.service;

import com.model.customer.CustomerType;
import com.model.faccility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();
}

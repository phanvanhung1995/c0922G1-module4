package com.service.impl;

import com.model.faccility.FacilityType;
import com.model.faccility.RentType;
import com.repository.IFacilityTypeRepository;
import com.repository.IRentTypeRepository;
import com.service.IFacilityTypeService;
import com.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}

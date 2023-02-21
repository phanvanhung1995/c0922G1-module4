package com.service.impl;

import com.model.customer.Customer;
import com.model.faccility.Facility;
import com.repository.IFacilityRepository;
import com.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public Facility findById(Long id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void delete(Long id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> findAll(String name, String facilityTypeId, Pageable pageable) {
        return facilityRepository.findAll(name,facilityTypeId,pageable);
    }
}

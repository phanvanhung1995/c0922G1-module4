package com.service;

import com.model.customer.Customer;
import com.model.faccility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAllFacility();
    Facility findById(Long id);

    void save(Facility facility);

    void delete(Long id);

    Page<Facility> findAll(String name, String facilityTypeId, Pageable pageable);
}

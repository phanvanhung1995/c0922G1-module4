package com.service;

import com.model.customer.Customer;
import com.model.faccility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Facility findById(Long id);

    void save(Facility facility);

    void delete(Long id);

    Page<Facility> findAll(String name, String facilityTypeId, Pageable pageable);
}

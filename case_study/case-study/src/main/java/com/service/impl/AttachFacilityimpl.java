package com.service.impl;

import com.model.contract.AttachFacility;
import com.repository.IAttachFacilityRepository;
import com.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachFacilityimpl implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}

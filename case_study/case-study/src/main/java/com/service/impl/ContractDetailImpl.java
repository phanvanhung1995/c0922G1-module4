package com.service.impl;

import com.model.contract.AttachFacility;
import com.model.contract.ContractDetail;
import com.repository.IAttachFacilityRepository;
import com.repository.IContractDetailRepository;
import com.service.IAttachFacilityService;
import com.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailImpl implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }
}

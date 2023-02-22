package com.service.impl;

import com.model.contract.AttachFacility;
import com.model.contract.Contract;
import com.model.dto.IAttachFacilityDto;
import com.model.dto.IContractDto;
import com.repository.IContractDtoReoisitory;
import com.repository.IContractRepository;
import com.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
   private IContractRepository contractRepository;
    @Autowired
    private IContractDtoReoisitory contractDtoReoisitory;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Contract findById(long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Page<IContractDto> findAllContract(Pageable pageable) {
        return contractDtoReoisitory.findAllContract(pageable);
    }

    @Override
    public List<IAttachFacilityDto> findAttachFacility(long id) {
        return contractDtoReoisitory.findAttachFacility(id);
    }
}

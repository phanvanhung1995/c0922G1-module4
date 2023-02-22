package com.service;

import com.model.contract.AttachFacility;
import com.model.contract.Contract;
import com.model.dto.IAttachFacilityDto;
import com.model.dto.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    Contract findById(long id);

    void save(Contract contract);

    Page<IContractDto> findAllContract(Pageable pageable);

    List<IAttachFacilityDto> findAttachFacility(long id);


}

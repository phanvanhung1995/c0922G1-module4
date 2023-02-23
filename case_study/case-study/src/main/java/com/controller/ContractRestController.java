package com.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.contract.AttachFacility;
import com.model.dto.IAttachFacilityDto;
import com.model.dto.IContractDto;
import com.service.impl.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/api/contract")
public class ContractRestController {
    @Autowired
    private ContractService contractService;

    @GetMapping("/{contractId}")
    public ResponseEntity<List<IAttachFacilityDto>> showList(@PathVariable long contractId) {
        List<IAttachFacilityDto> attachFacilityList = contractService.findAttachFacility(contractId);
        if (attachFacilityList == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }

}

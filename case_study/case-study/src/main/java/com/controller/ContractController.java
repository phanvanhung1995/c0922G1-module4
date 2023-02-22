package com.controller;

import com.model.contract.Contract;
import com.service.impl.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;


    @GetMapping("/")
    public String showList(Model model, @PageableDefault(size = 5,page = 0) Pageable pageable) {
        model.addAttribute("contractList",contractService.findAllContract(pageable));
        return "/contract/list";
    }

}

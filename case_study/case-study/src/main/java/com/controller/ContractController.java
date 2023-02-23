package com.controller;

import com.model.contract.Contract;
import com.service.impl.AttachFacilityimpl;
import com.service.impl.ContractDetailImpl;
import com.service.impl.ContractService;
import com.service.impl.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractDetailImpl contractDetail;
    @Autowired
    private AttachFacilityimpl facilityImpl;
    @Autowired
    private FacilityService facilityService;


    @GetMapping("/")
    public String showList(Model model, @PageableDefault(size = 5,page = 0) Pageable pageable) {
        model.addAttribute("contractList",contractService.findAllContract(pageable));
        return "/contract/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contract",new Contract());
        model.addAttribute("contractDetail",contractDetail.findAll());
        model.addAttribute("attachFacility",facilityImpl.findAll());
        model.addAttribute("facility",facilityService.findAllFacility());
        return "/contract/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contract contract, RedirectAttributes redirect) {
        redirect.addFlashAttribute("mess","thêm mới thành công");
        contractService.save(contract);
        return "redirect:/contract/";
    }
}

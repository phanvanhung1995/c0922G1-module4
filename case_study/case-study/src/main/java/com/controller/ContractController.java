package com.controller;

import com.model.contract.Contract;
import com.model.contract.ContractDetail;
import com.model.dto.ContractDetailDto;
import com.service.impl.AttachFacilityimpl;
import com.service.impl.ContractDetailImpl;
import com.service.impl.ContractService;
import com.service.impl.FacilityService;
import org.springframework.beans.BeanUtils;
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
    private ContractDetailImpl contractDetailImpl;
    @Autowired
    private AttachFacilityimpl facilityImpl;
    @Autowired
    private FacilityService facilityService;


    @GetMapping("/")
    public String showList(Model model, @PageableDefault(size = 5,page = 0) Pageable pageable) {
        model.addAttribute("contractList",contractService.findAllContract(pageable));
        model.addAttribute("contractDetails",contractDetailImpl.findAll());
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("attachFacilities",facilityImpl.findAll());
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        return "/contract/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contract",new Contract());
        model.addAttribute("contractDetail",contractDetailImpl.findAll());
        model.addAttribute("attachFacility",facilityImpl.findAll());
        model.addAttribute("facility",facilityService.findAllFacility());
        model.addAttribute("contractDetailDto", new ContractDetailDto());

        return "/contract/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Contract contract, RedirectAttributes redirect) {
        redirect.addFlashAttribute("mess","thêm mới thành công");
        contractService.save(contract);
        return "redirect:/contract/";
    }

    @PostMapping("/add")
    public String addAttachFacility(@ModelAttribute ContractDetail contractDetail) {
        contractDetailImpl.saveContractDetail(contractDetail);
        return "redirect:/contract/";
    }

    @PostMapping("contract/addAttachFacility")
    public String saveAttachFacility(@ModelAttribute ContractDetailDto contractDetailDto) {
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto, contractDetail);
        contractDetailImpl.saveContractDetail(contractDetail);
        return"redirect:/contract";
    }
}

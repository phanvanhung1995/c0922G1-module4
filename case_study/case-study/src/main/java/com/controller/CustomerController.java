package com.controller;

import com.model.customer.Customer;
import com.service.impl.CustomerService;
import com.service.impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/")
    public String showCustomer(Model model,
                               @PageableDefault(size = 5, page = 0) Pageable pageable) {
        Page<Customer> customerPage = customerService.findAll(pageable);
        model.addAttribute("customerPage",customerPage);
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer",new Customer());
        model.addAttribute("customerType",customerTypeService.findAll());
        return "customer/create";
    }
}

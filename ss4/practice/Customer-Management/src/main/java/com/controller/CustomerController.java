package com.controller;

import com.model.Customer;
import com.service.IcustomerService;
import com.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private IcustomerService customerService = new CustomerService();

    @GetMapping("")
    public String showListCustomer(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "/index";
    }

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Customer customer) {
        customer.setId((int) (Math.random()));
        customerService.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer) {
        customerService.update(customer.getId(), customer);
        return "redirect:/customer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes attributes) {
        customerService.remove(customer.getId());
        attributes.addFlashAttribute("success","xóa thành công");
        return "redirect:/customer";
    }

@GetMapping("/view/{id}")
    public String view(@PathVariable int id,Model model) {
        model.addAttribute("customer",customerService.findById(id));
        return "/view";
}
}



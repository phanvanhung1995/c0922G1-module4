package com.controller;

import com.model.customer.Customer;
import com.model.customer.CustomerType;
import com.service.impl.CustomerService;
import com.service.impl.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("/")
    public String showCustomer(@RequestParam(defaultValue = "", required = false) String name, @RequestParam(defaultValue = "", required = false) String email,
                               @RequestParam( defaultValue = "",required = false) String customerTypeId,
                               Model model, @PageableDefault(size = 5, page = 0) Pageable pageable) {
        Page<Customer> customerPage = customerService.findAll(name,email,customerTypeId,pageable);
        model.addAttribute("name",name);
        model.addAttribute("email",email);
        model.addAttribute("customerTypeId",customerTypeId);
        model.addAttribute("customerPage", customerPage);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        if (customerPage==null) {
            model.addAttribute("mess","không có khách hàng nào");
        }
        return "/customer/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/save")
    public String create(@ModelAttribute Customer customer, RedirectAttributes redirect) {
       boolean check = customerService.save(customer);
       if (check) {
           redirect.addFlashAttribute("mess", "thêm mới thành công");
           return "redirect:/customer/";
       } else {
           redirect.addFlashAttribute("mess", "id đã tồn tại");
           return "/customer/create";
       }

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            model.addAttribute("mess", "id không tồn tại");
            return "redirect:/customer/";
        }
        model.addAttribute("customer", customer);
        model.addAttribute("customerTypes", customerTypeService.findAll());
        return "/customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@ModelAttribute Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("mess", "edit thành công");
        return "redirect:/customer/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id, RedirectAttributes redirect) {
        customerService.delete(id);
        redirect.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/customer/";
    }


}

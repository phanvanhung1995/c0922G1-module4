package com.controller;

import com.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "/employee/create";
    }
        @GetMapping()
        public String showForm1() {
            return "/employee/index";
    }

    @PostMapping("/add")
    public String submid(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        model.addAttribute("mess","thêm mới thành công");
        return "/employee/index";
    }
}

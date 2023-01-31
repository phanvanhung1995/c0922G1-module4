package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greating")
    public String greating(@RequestParam String name , Model model) {
        model.addAttribute("name",name);
        return "index";
    }
}

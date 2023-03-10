package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConverter {
    @GetMapping("/convert")
    public String showForm() {
        return "convert";
    }

    @PostMapping ("/convert")
    public String Convert(@RequestParam double usd, Model model) {
        double vnd = usd*23000;
        model.addAttribute("vnd",vnd);
        return "convert";
    }

}

package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showForm() {
        return "/index";
    }

    @PostMapping("/save")
    public String calculator(@RequestParam double number1,@RequestParam double number2,@RequestParam String action ,Model model) {
        double number = 0;
        switch (action) {
            case "+":
                number = number1 + number2;
                break;
            case "-":
                number = number1 - number2;
                break;
            case "*":
                number = number1 * number2;
                break;
            case "/":
                if (number2==0) {
                    return "lỗi";
                }
                number = number1 / number2;
                break;
        }
        model.addAttribute("number",number );
        return "/index";
    }
}

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
        String number ;
        switch (action) {
            case "+":
                number = String.valueOf(number1 + number2);
                break;
            case "-":
                number = String.valueOf(number1 - number2);
                break;
            case "*":
                number = String.valueOf(number1 * number2);
                break;
            default:
                if (number2==0) {
                    number = "lỗi không chia cho 0" ;
                    break;
                }
                number = String.valueOf(number1 / number2);
                break;
        }
        model.addAttribute("number",number );
        return "/index";
    }
}

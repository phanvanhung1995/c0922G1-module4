package com.example.controller;

import com.example.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Translate {
    @Autowired
    TranslateService translateService;

    @GetMapping("/translate")
    public String showForm() {
        return "/translate";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String english, Model model) {
        model.addAttribute("vietnamese", translateService.translate(english));
        return "/translate";
    }
}
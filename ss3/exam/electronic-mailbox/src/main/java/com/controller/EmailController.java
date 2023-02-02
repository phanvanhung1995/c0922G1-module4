package com.controller;

import com.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;

@Controller
public class EmailController {

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("email", new Email());
        return "/email/create";
    }

    @PostMapping("/add")
    public String submid(@ModelAttribute Email email, Model model) {
        model.addAttribute("language", email.getLanguage());
        model.addAttribute("pageSize", email.getPageSize());
        model.addAttribute("spamFilter", email.isSpamFilter());
        model.addAttribute("signature", email.getSignature());
        model.addAttribute("mess","thêm mới thành công");
        return"/email/list";
    }

}

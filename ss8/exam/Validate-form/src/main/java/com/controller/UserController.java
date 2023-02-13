package com.controller;

import com.model.User;
import com.model.UserDto;
import com.service.impl.UserServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/")
    public String showList(Model model, @RequestParam(required = false,defaultValue = "") String lastName
    , @RequestParam(required = false,defaultValue = "" ) String age,
                           @PageableDefault(size = 2,page = 0,direction = Sort.Direction.ASC)Pageable pageable) {

        Page<User> userPage = userService.findAllByLastNameAndAge(lastName,age,pageable);
        model.addAttribute("userPage", userPage);
        model.addAttribute("lastName",lastName);
        model.addAttribute("age",age);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "/create";
    }

    @PostMapping("/save")
    public String Save(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDto", userDto);

            return "/create";
        }

        if (userService.checkEmail(userDto.getEmail())) {
            model.addAttribute("userDto", userDto);
            bindingResult.rejectValue("email", "email", "email không được trùng lặp");
            return "/create";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.create(user);
        return "redirect:/";
    }
}

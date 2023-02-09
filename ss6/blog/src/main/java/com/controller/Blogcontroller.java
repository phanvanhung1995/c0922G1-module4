package com.controller;

import com.model.Blog;
import com.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
public class Blogcontroller {
    @Autowired
   private BlogService blogService;


//    @GetMapping("/")
//    public String showList(Model model) {
//        List<Blog> blog = blogService.findAll();
//        model.addAttribute("blogList", blog);
//        return "/list";
//    }


//    @GetMapping("/")
//    public String showList(Model model,
//                           @PageableDefault(size = 2,page = 0,sort = "name",direction = Sort.Direction.ASC) Pageable pageable) {
//        Page<Blog> blogPage = blogService.findAll(pageable);
//        model.addAttribute("blogPage", blogPage);
//        return "/list";
//    }

    @GetMapping("/")
    public String showList(Model model,@RequestParam(required = false,defaultValue ="") String nameSearch,
                           @PageableDefault(size = 2,page = 0,sort = "name",direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Blog> blogPage = blogService.findByNameContaining(nameSearch,pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("nameSearch", nameSearch);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String create(Blog blog) {
        blogService.create(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            model.addAttribute("mess", "không tìm thấy sản phẩm");
        }
        model.addAttribute("blog", blog);
        return "/edit";
    }

    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogService.update(blog);
        model.addAttribute("message", "blog updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        blogService.delete(id);
        redirect.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String showProduct(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }
}

package com.controller;

import com.model.Product;
import com.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;



@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String create(Product product) {
        productService.create(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            model.addAttribute("mess", "không tìm thấy sản phẩm");
        }
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.edit(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        productService.delete(id);
        redirect.addFlashAttribute("mess", "xóa thành công");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String showProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String showListProductSearch(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.search(name));
        if (productService.search(name) == null) {
            model.addAttribute("mess", "không có sản phẩm nào cùng tên");
        }
        return "/list";
    }
}

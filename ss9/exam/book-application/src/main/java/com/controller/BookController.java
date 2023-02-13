package com.controller;

import com.model.Book;
import com.model.BookCard;
import com.service.impl.BookCardService;
import com.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.soap.SAAJResult;
import java.util.Random;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookCardService bookCardService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("bookList",bookService.findAll());
        return "/views/list";
    }

    @GetMapping("/bookCard")
    public String showListBookCard(Model model) {
        model.addAttribute("bookCardList",bookCardService.findAll());
        return "/views/bookCard";
    }

    @GetMapping("/borrow/{id}")
    public String showBook(Model model, @PathVariable int id) {
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "views/borrowBook";
    }

    @PostMapping("/borrow")
    public String borrow(@ModelAttribute Book book) {
        String bookID =  String.valueOf(new Random().nextInt(99999 - 10000 + 1) + 10000);
        BookCard bookCard = new BookCard(bookID,book.getName(),book.getBookCode());
        bookCardService.save(bookCard);
        book.setQuality(book.getQuality()-1);
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/pay")
    public String pay(Model model) {
        return "/views/pay";
    }

    @PostMapping("/pay")
    public String pay(@RequestParam  String idCard,Model model) {
        BookCard bookCard = bookCardService.findByName(idCard);
        if (bookCard==null) {
            model.addAttribute("mess","mã trả sách sai mời nhập lại : ");
            return "/views/pay";
        } else {
            Book book = bookService.findByBookCode(bookCard.getBookCode());
            bookCardService.delete(bookCard.getId());
            book.setQuality(book.getQuality()+1);
            bookService.save(book);
        }
        return "redirect:/";
    }
}

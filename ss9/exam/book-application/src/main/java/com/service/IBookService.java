package com.service;

import com.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll() ;
    Book findById(int id);

    void save(Book book) ;

    Book findByBookCode(String bookCode);
}

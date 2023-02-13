package com.service;

import com.model.Book;
import com.model.BookCard;

import java.util.List;

public interface IBookCardService {
    List<BookCard> findAll() ;
    BookCard findById(int id);

    void save(BookCard bookCard) ;
    void delete(int id);
    BookCard findByName(String name);
}

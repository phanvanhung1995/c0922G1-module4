package com.service.impl;

import com.model.BookCard;
import com.repository.IBookCardRepository;
import com.service.IBookCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookCardService implements IBookCardService {
    @Autowired
    private IBookCardRepository bookCardRepository;
    @Override
    public List<BookCard> findAll() {
        return bookCardRepository.findAll();
    }

    @Override
    public BookCard findById(int id) {
        return bookCardRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BookCard bookCard) {
        bookCardRepository.save(bookCard);
    }

    @Override
    public void delete(int id) {
        bookCardRepository.deleteById(id);
    }

    @Override
    public BookCard findByName(String name) {
        return bookCardRepository.findByIdCard(name);
    }

}

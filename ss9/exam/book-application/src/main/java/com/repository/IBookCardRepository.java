package com.repository;

import com.model.Book;
import com.model.BookCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookCardRepository extends JpaRepository<BookCard,Integer> {
    BookCard findByIdCard(String name);
}

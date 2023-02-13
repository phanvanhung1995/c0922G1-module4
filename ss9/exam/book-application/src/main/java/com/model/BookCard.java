package com.model;

import org.springframework.transaction.reactive.GenericReactiveTransaction;

import javax.persistence.*;

@Entity
public class BookCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String idCard;
    private String name;
    private String bookCode;



    public BookCard() {
    }

    public BookCard(int id, String idCard, String name, String bookCode) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.bookCode = bookCode;
    }

    public BookCard(String bookID, String name, String bookCode) {
        this.idCard = bookID;
        this.name = name;
        this.bookCode =bookCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }
}

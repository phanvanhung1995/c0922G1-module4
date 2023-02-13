package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {
    private static int count = 0;
    private static int count1 = 0;

    @Pointcut("execution(* com.controller.BookController.borrow(..))" + "||execution(* com.controller.BookController.pay(..))")
    public void getAllBorrowBook() {
    }

    @After(value = "getAllBorrowBook()")
    public void print() {
        count++;
        System.out.println("mượn hoặc trả sách ần thứ  : " + count);
    }

    @Pointcut("execution(* com.controller.BookController.*())")
    public void numberOfHits() {
    }

    @After(value = "numberOfHits()")
    public void print2() {
        count1++;
        System.out.println("số lượt người ghé thăm thứ : " + count1);
    }
}

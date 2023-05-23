package com.pukhaev.spring.aop;

import org.springframework.stereotype.Component;

@Component // id -> uniLibrary
public class UniLibrary extends AbstractLibrary {

    public void getBook(Book book) {
        System.out.println("Мы берем книгу из UniLibrary: " + book.getName());
    }


    public void getMagazin() {
        System.out.println("Мы берем журнал из UniLibrary");
    }

    protected String returnBook() {
        System.out.println("Мы возвращаем книгу в UniLibrary");
        return "OK";
    }
}

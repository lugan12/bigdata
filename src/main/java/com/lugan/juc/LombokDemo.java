package com.lugan.juc;

import com.lugan.entity.Book;

public class LombokDemo {
    public static void main(String[] args) {
        Book book = new Book();
        String author = book.getAuthor();
        System.out.println(book.setId(12).setBookName("apple").setPrice(14d).setAuthor("lugan"));
    }
}

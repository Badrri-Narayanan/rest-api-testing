package com.restApi.demo;

import com.restApi.demo.entity.Book;

import java.util.List;

public class BookTestData {
    public static List<Book> getBooks() {
        return List.of(
                new Book(1l, "Book1", "Author1"),
                new Book(2l, "Book2", "Author2"),
                new Book(3l, "Book3", "Author3")
        );
    }
}

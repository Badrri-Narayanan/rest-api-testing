package com.restApi.demo.service;

import com.restApi.demo.entity.Book;
import com.restApi.demo.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book insert(Book book) {
        return bookRepository.save(book);
    }
}

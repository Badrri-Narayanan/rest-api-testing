package com.restApi.demo.integrationTests;

import com.restApi.demo.BookTestData;
import com.restApi.demo.entity.Book;
import com.restApi.demo.integrationTests.config.IntegrationTest;
import com.restApi.demo.repository.BookRepository;
import com.restApi.demo.service.BookService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@IntegrationTest
public class DemoApplicationIntegrationTests {
    @Autowired private BookRepository bookRepository;

    @Autowired private BookService bookService;

    @BeforeEach
    void setUp() {
        List<Book> books = BookTestData.getBooks();
        bookRepository.saveAll(books);
    }

    @Test
    void shouldGetAllBooks() {
        List<Book> books = bookService.getAllBooks();

        assertThat(books.size()).isEqualTo(3);
    }

    @Test
    void shouldInsertBook() {
        bookRepository.deleteAll();
        Book book1 = BookTestData.getBooks().get(0);

        bookService.insert(book1);

        List<Book> books = bookService.getAllBooks();

        assertThat(books.size()).isEqualTo(1);
        assertThat(book1).isEqualTo(books.get(0));
    }

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
    }
}

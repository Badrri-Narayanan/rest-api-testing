package com.restApi.demo;

import com.restApi.demo.entity.Book;
import com.restApi.demo.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class DemoApplicationTests {
	@Autowired
	BookService bookService;

	@Test
	void shouldFetchAllBooks() {
		List<Book> books = bookService.getAllBooks();

		assertTrue(books.size() > 0);
	}
}

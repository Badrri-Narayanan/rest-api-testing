package com.restApi.demo.unitTests;

import com.restApi.demo.BookTestData;
import com.restApi.demo.entity.Book;
import com.restApi.demo.repository.BookRepository;
import com.restApi.demo.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DemoApplicationUnitTests {
	@InjectMocks
	BookService bookService;

	@Mock private BookRepository bookRepository;

	@Test
	void shouldFetchAllBooks() {
		when(bookRepository.findAll()).thenReturn(BookTestData.getBooks());
		List<Book> books = bookService.getAllBooks();

		assertThat(books.isEmpty()).isFalse();

		assertThat(books.size()).isEqualTo(3);
	}

	@Test
	void shouldInsertBook() {
		Book book1 = BookTestData.getBooks().get(0);
		when(bookRepository.save(book1)).thenReturn(book1);

		bookService.insert(book1);

		verify(bookRepository, times(1)).save(book1);
	}
}

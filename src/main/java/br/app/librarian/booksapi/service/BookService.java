package br.app.librarian.booksapi.service;

import br.app.librarian.booksapi.domain.model.Book;
import br.app.librarian.booksapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book registerBook(final Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getBooks(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Book> pages = bookRepository.findAll(paging);
        return pages.stream().collect(Collectors.toList());
    }

}

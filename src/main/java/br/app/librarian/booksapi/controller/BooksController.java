package br.app.librarian.booksapi.controller;

import br.app.librarian.booksapi.domain.model.Book;
import br.app.librarian.booksapi.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<Book> registerBook(@RequestBody Book book){
        Book bookSaved = bookService.registerBook(book);
        return new ResponseEntity<>(bookSaved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(@RequestParam("page") int page,
                                         @RequestParam("size") int size) {
        List<Book> allBooks = bookService.getBooks(page, size);
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

}

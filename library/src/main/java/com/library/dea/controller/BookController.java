package com.library.dea.controller;

import com.library.dea.entity.Book;
import com.library.dea.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id){
        return bookService.showById(id);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.showAll();
    }

    @PostMapping("/add")
    public Book createBook(@RequestBody Book book){
        return bookService.add(book);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBookById(@PathVariable Integer id){
        bookService.deleteBook(id);
    }
}


package com.library.dea.controller;

import com.library.dea.dto.BookDTO;
import com.library.dea.entity.Book;
import com.library.dea.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Books API", description = "CRUD operations for books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Book By Id")
    public Book getBook(@PathVariable Integer id){
        return bookService.showById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "Get All Books")
    public List<Book> getAllBooks(){
        return bookService.showAll();
    }



    @PostMapping("/add")
    @Operation(summary = "Add Books")
    public Book createBook(@RequestBody Book book){
        return bookService.add(book);
    }
    @PutMapping("/update/{id}")
    @Operation(summary = "Update Books")
    public Book updateBook(@PathVariable Integer id, @RequestBody BookDTO bookDTO){
        return bookService.update(id, bookDTO);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete Books")
    public void deleteBookById(@PathVariable Integer id){
        bookService.deleteBook(id);
    }
}


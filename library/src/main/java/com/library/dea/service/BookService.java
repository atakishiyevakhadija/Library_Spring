package com.library.dea.service;


import com.library.dea.dto.BookDTO;
import com.library.dea.entity.Book;
import com.library.dea.mapper.BookMapper;
import com.library.dea.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //create method (POST)
    public Book add(Book book){
        return bookRepository.save(book);
    }
    //show all books (GET)
    public List<Book> showAll(){
        return bookRepository.findAll();
    }


    //pagination
    public Page<Book> getBooks(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    public List<Book> getAllByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> getAllByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> getAllByMinPrice(Double price){
        return bookRepository.findByMinPrice(price);
    }

    public List<Book> getAllByMinAmount(Integer amount){
        return bookRepository.findByMinAmount(amount);
    }

    //show book by id (GET)
    public Book showById(Integer id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no such a Book!"));
    }

    public Book update(Integer id, BookDTO updatedBook){
        Book existing = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("No book with following id!"));

        existing.setTitle(updatedBook.getTitle());
        existing.setAuthor(updatedBook.getAuthor());
        existing.setPrice(updatedBook.getPrice());
        existing.setAmount(updatedBook.getAmount());
        return bookRepository.save(existing);

    }
    //delete method (DELETE)
    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

     //Pagination
    public Page<Book> findPaginated(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return bookRepository.findAll(pageable);
    }

    //search
    public Page<Book> search(String keyword, int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        return bookRepository.findByTitleContainingIgnoreCase(keyword, pageable);
    }

    public void saveDto(BookDTO bookDTO){
        Book entity = BookMapper.toEntity(bookDTO);
        bookRepository.save(entity);
    }
}

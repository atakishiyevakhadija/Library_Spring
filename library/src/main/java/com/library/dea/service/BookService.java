package com.library.dea.service;


import com.library.dea.dto.BookDTO;
import com.library.dea.entity.Author;
import com.library.dea.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;


public interface BookService {

    //create method (POST)
    public Book add(Book book);
    //show all books (GET)
    public List<Book> showAll();


    //pagination
    public Page<Book> getBooks(Pageable pageable);
//
//    public List<Book> getAllByTitle(String title);
//
//    public List<Book> getAllByAuthor(String author);
//
//    public List<Book> getAllByMinPrice(Double price);
//
//    public List<Book> getAllByMinAmount(Integer amount);

//    public List<Author> getAllAuthors();

    //show book by id (GET)
    public Book showById(Integer id);

//    public Author findAuthorById(Long id);

    public Book update(Integer id, BookDTO updatedBook);

//delete method (DELETE)
public void deleteBook(Integer id);

//Pagination
public Page<Book> findPaginated(int page, int size);

//search
public Page<Book> search(String keyword, int page, int size);

public void saveDto(BookDTO bookDTO);
}


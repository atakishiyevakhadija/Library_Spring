package com.library.dea.service;

import com.library.dea.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAllAuthors();

    AuthorDTO getAuthorById(Long id);
    AuthorDTO createAuthor(AuthorDTO authorDTO);
    AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO);

    void deleteAuthor(Long id);
}

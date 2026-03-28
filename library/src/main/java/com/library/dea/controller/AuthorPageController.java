package com.library.dea.controller;


import com.library.dea.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorPageController {

    private final AuthorService authorService;


    public AuthorPageController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());

        return "authors/list";
    }
}

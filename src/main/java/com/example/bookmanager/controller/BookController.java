package com.example.bookmanager.controller;

import com.example.bookmanager.model.Book;
import com.example.bookmanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "books";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add-book";
    }

    @PostMapping
    public String addBook(@ModelAttribute Book book) {
        bookService.add(book);
        return "redirect:/books";
    }

    @PostMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.delete(id);
        return "redirect:/books";
    }
}

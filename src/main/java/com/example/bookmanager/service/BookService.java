package com.example.bookmanager.service;

import com.example.bookmanager.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();

    public BookService() {
        // Sample data
        books.add(new Book(1, "De Men Phieu Luu Ky", "To Hoai"));
        books.add(new Book(2, "Tat Den", "Ngo Tat To"));
    }

    public List<Book> getAll() {
        return books;
    }

    public Optional<Book> getById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst();
    }

    public void add(Book book) {
        books.add(book);
    }

    public boolean update(int id, Book updatedBook) {
        return getById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            return true;
        }).orElse(false);
    }

    public boolean delete(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}

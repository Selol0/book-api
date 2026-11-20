package com.example.bookapi;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Integer id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        if (bookRepository.existsByTitleIgnoreCaseAndAuthorIgnoreCase(book.getTitle(), book.getAuthor())) {
            throw new BookAlreadyExistsException("Book already exists: " + book.getTitle());
        }
        book.setId(null);
        return bookRepository.save(book);
    }

    public Optional<Book> updateBook(Integer id, Book updated) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updated.getTitle());
            book.setAuthor(updated.getAuthor());
            book.setBorrowed(updated.isBorrowed());
            return bookRepository.save(book);
        });
    }

    public boolean deleteBook(Integer id) {
        if (!bookRepository.existsById(id)) {
            return false;
        }
        bookRepository.deleteById(id);
        return true;
    }
}
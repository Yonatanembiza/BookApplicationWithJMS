package books.BookApplication.service;

import books.BookApplication.domain.Book;
import books.BookApplication.integration.BookModificationTracker;
import books.BookApplication.repository.BookRepository;
import books.BookApplication.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Override
    public String addBook(String isbn, Book book) {
        // publishing BookModificationEven for book addition
        applicationEventPublisher.publishEvent(new BookModificationTracker(this, book, "Added"));
        return bookRepository.addBook(isbn, book);
    }

    @Override
    public String updateBook(String isbn, Book book) {
        return bookRepository.updateBook(isbn, book);
    }

    @Override
    public String deleteBook(String isbn) {
        Book book = bookRepository.getBook(isbn);
        if (book != null)
            applicationEventPublisher.publishEvent(new BookModificationTracker(this, book, "Deleted"));
        return bookRepository.deleteBook(isbn);
    }

    @Override
    public Book getBook(String isbn) {
        return bookRepository.getBook(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}

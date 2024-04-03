package books.BookApplication.repository;

import books.BookApplication.domain.Book;

import java.util.List;

public interface BookRepository {
    String addBook(String isbn, Book book);
    String updateBook(String isbn, Book book);
    String deleteBook(String isbn);
    Book getBook(String isbn);
    List<Book> getAllBooks();
}

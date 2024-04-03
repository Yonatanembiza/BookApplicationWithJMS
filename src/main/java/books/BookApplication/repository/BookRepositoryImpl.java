package books.BookApplication.repository;

import books.BookApplication.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository {
    Map<String, Book> bookDB = new HashMap<>();
    @Override
    public String addBook(String isbn, Book book){
        if(bookDB.containsKey(isbn))
            return "The book with the same ISBN is already in the dB.";
        bookDB.put(isbn, book);
        return "The book was successfully added.";
    }
    @Override
    public String deleteBook(String isbn){
        if(!bookDB.containsKey(isbn))
            return "The book by the given ISBN is not in the dB.";
        bookDB.remove(isbn);
        return "The book was successfully removed.";
    }
    @Override
    public String updateBook(String isbn, Book book){
        if(bookDB.containsKey(isbn)){
            bookDB.replace(isbn, book);
            return "Book was successfully updated";
        }
        return "Book by the same ISBN is not found int he dB";
    }
    @Override
    public Book getBook(String isbn){
        if(!bookDB.isEmpty())
            return bookDB.get(isbn);
        return null;
    }
    @Override
    public List<Book> getAllBooks(){
        if(!bookDB.isEmpty()) {
            List<Book> availableBooks = new ArrayList<>();
            bookDB.forEach((s, book) -> availableBooks.add(book));
            return availableBooks;
        }
        return null;
    }
}

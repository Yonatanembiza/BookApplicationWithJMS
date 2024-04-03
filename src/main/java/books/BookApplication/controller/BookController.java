package books.BookApplication.controller;

import books.BookApplication.domain.Book;
import books.BookApplication.integration.BookModificationTracker;
import books.BookApplication.integration.JMSSender;
import books.BookApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private JMSSender jmsSender;

    @PostMapping
    public String addBook(@RequestBody Book book){
        String message = "A book was added into the dB: ";
        jmsSender.sendMessage(message, book);
        return bookService.addBook(book.getIsbn(), book);
    }
    @GetMapping("/{isbn}")
    public Book getBook(@PathVariable String isbn){
        Book book = bookService.getBook(isbn);
        String message = "A book was fetched from the dB: ";
        jmsSender.sendMessage(message, book);
        return  book;
    }
    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PutMapping("/{isbn}")
    public String updateBook(@PathVariable String isbn, @RequestBody Book book){
        String message = "A book was updated: ";
        jmsSender.sendMessage(message, book);
        return bookService.updateBook(isbn, book);
    }
    @DeleteMapping("/{isbn}")
    public String deleteBook(@PathVariable String isbn){
        Book book = bookService.getBook(isbn);
        String message = "A book was deleted from the dB: ";
        jmsSender.sendMessage(message, book);
        return bookService.deleteBook(isbn);
    }
}

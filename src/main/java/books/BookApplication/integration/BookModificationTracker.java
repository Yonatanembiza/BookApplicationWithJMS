package books.BookApplication.integration;

import books.BookApplication.domain.Book;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookModificationTracker extends ApplicationEvent {
    private final Book modifiedBook;
    private final LocalTime localTime;
    private final String message;

    public BookModificationTracker(Object source, Book modifiedBook, String message) {
        super(source);
        this.modifiedBook = modifiedBook;
        this.localTime = LocalTime.now();
        this.message = message;
    }

    public Book getModifiedBook() {
        return modifiedBook;
    }

    public LocalTime getLocalDateTime() {
        return localTime;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "BookModificationTracker{" +
                "modifiedBook=" + modifiedBook +
                '}';
    }
}

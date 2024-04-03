package books.BookApplication.integration;

import books.BookApplication.domain.Book;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookModificationEventListener {
    @EventListener
    public void bookModificationListener(BookModificationTracker event){
        Book modifiedBook = event.getModifiedBook();
        System.out.println(modifiedBook+" was "+event.getMessage()+" at "+event.getLocalDateTime());
    }
}

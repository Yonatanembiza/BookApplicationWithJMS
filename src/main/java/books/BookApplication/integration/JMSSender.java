package books.BookApplication.integration;

import books.BookApplication.domain.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JMSSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(String message, Book book){
        ObjectMapper objectMapper  = new ObjectMapper();
        try {
            String bookAsString = objectMapper.writeValueAsString(book);
            System.out.println(message + bookAsString);
            jmsTemplate.convertAndSend("testQueue", bookAsString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

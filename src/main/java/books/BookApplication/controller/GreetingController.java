package books.BookApplication.controller;

import books.BookApplication.domain.Book;
import books.BookApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("app/v1/books")
public class GreetingController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }
}

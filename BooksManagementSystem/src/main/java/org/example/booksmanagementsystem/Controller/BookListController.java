package org.example.booksmanagementsystem.Controller;

import org.example.booksmanagementsystem.model.Book;
import org.example.booksmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:14
 */
@RequestMapping("/book")
@RestController
public class BookListController {
    @Autowired
    BookService bookService;
    @Autowired
    BookService bookService1;

    @RequestMapping("/getBookList")
    public List<Book> getBookList() {
        return bookService.getAllBooks();
    }
}

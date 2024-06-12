package org.example.booksmanagementsystem;

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
    @RequestMapping("/getBookList")
    public List<Book> getBookList() {
        BookService bookService = new BookService();
        bookService.mock();
        return bookService.getBooks();
    }
}

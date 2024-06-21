package org.example.booksmanagementsystem.Controller;

import lombok.extern.slf4j.Slf4j;
import org.example.booksmanagementsystem.component.PageInfo;
import org.example.booksmanagementsystem.component.ReturnType;
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
@Slf4j
@RestController
public class BookListController {
    @Autowired
    BookService bookService;

    @RequestMapping("/getBookList")
    public ReturnType<List<Book>,PageInfo> getBookList(PageInfo pageInfo) {
        log.info("getBookList:{}",pageInfo);
        return bookService.getAllBooksByPageInfo(pageInfo);
    }
    @RequestMapping("/addBook")
    public String addBook(Book book) {
        log.info("addBook:{}",book);
        return bookService.addBook(book);
    }
}

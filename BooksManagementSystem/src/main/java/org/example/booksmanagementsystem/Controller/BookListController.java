package org.example.booksmanagementsystem.Controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.example.booksmanagementsystem.Enum.LoginStatus;
import org.example.booksmanagementsystem.component.PageInfo;
import org.example.booksmanagementsystem.component.ReturnType;
import org.example.booksmanagementsystem.component.Session;
import org.example.booksmanagementsystem.model.Book;
import org.example.booksmanagementsystem.model.User;
import org.example.booksmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    Session session;

    @RequestMapping("/getBookList")
    public ReturnType<List<Book>, PageInfo> getBookList(PageInfo pageInfo, HttpSession httpSession) {
        log.info("getBookList:{}", pageInfo);
        User user = (User) httpSession.getAttribute(session.getUserInfo());
        log.info("getBookList访问用户:{}", user);
        ReturnType returnType = bookService.getAllBooksByPageInfo(pageInfo);
        if (user == null) {
            returnType.setLoginStatus(LoginStatus.NOT_LOG);
        } else {
            returnType.setLoginStatus(LoginStatus.SUCCESS);
        }
        return returnType;
    }

    @RequestMapping("/addBook")
    public String addBook(Book book) {
        log.info("addBook:{}", book);
        return bookService.addBook(book);
    }

    @RequestMapping("/selectBookId")
    public Book selectBookById(Integer bookId) {
        log.info("selectBookId:{}", bookId);
        Book book = bookService.selectBookById(bookId);
        return book;
    }

    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        log.info("updateBook:{}", book);
        return bookService.updateBook(book);
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(Book book) {
        log.info("deleteBook:{}", book);
        book.setStatus(0);
        return bookService.updateBook(book);
    }

    @RequestMapping("/batchDeleteBook")
    public String batchDeleteBook(@RequestParam List<Integer> bookIds) {
        log.info("batchDeleteBook:{}", bookIds);
        return bookService.deleteBookByIds(bookIds);
    }
}

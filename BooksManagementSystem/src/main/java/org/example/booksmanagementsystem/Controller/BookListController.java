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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    //事务相关
    @Autowired
    private DataSourceTransactionManager transactionManager;//可以认为这是一个工具，用来产生并回到存档点
    @Autowired
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/getBookList")
    public ReturnType<List<Book>, PageInfo> getBookList(PageInfo pageInfo, HttpSession httpSession) {
        log.info("getBookList:{}", pageInfo);
        return bookService.getAllBooksByPageInfo(pageInfo);
    }

    @RequestMapping(value = "/addBook", produces = "application/json")
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

    @RequestMapping(value = "/updateBook", produces = "application/json")
    public String updateBook(Book book) {
        log.info("updateBook:{}", book);
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "/deleteBook", produces = "application/json")
    public String deleteBook(Book book) {
        log.info("deleteBook:{}", book);
        book.setStatus(0);
        return bookService.updateBook(book);
    }

    @RequestMapping(value = "/batchDeleteBook", produces = "application/json")
    public String batchDeleteBook(@RequestParam List<Integer> bookIds) {
        log.info("batchDeleteBook:{}", bookIds);
        return bookService.deleteBookByIds(bookIds);
    }

    @RequestMapping("/testTran")
    public String testTran(Book book) throws Exception {
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        bookService.updateBook(book);
        return "success";
    }

    @Transactional
    @RequestMapping(value = "/testTran1", produces = "application/json")
    public String testTran1(Book book) {
        bookService.updateBook(book);
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return "success";
    }

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ)
    @RequestMapping(value = "/testTran2", produces = "application/json")
    public String testTran2(Book book) throws IOException {
        bookService.updateBook(book);
        throw new IOException();
    }
}

package org.example.booksmanagementsystem.service;


import org.example.booksmanagementsystem.dao.BookDao;
import org.example.booksmanagementsystem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:31
 */
@Component
public class BookService {
    @Autowired
    BookDao bookDao;
    public List<Book> getAllBooks() {
        List<Book> bookList = bookDao.mock();
        for (Book book : bookList) {
            if (book.getStatus() == 1) {
                book.setStatusCH("可借阅");
            } else {
                book.setStatusCH("不可借阅");
            }
        }
        return bookList;
    }
}

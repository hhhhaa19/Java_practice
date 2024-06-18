package org.example.booksmanagementsystem.service;

import lombok.Getter;
import lombok.Setter;
import org.example.booksmanagementsystem.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-13
 * Time: 10:44
 */
@Component
public class BookService2 {

    @Autowired
    private  BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }
}
